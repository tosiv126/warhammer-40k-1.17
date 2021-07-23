package com.tosiv.warhammer.item;

import com.tosiv.warhammer.entity.BulletEntity;
import com.tosiv.warhammer.util.enums.Caliber;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GunItem extends Item implements ReloadableItem {

    private final int shootSpeed;
    private final Caliber caliber;
    private final HashSet<Integer> magazineCapacities = new HashSet<>();
    private final boolean automatic;
    private final int spreadAmount;
    private final float velocityMultiplier;
    private final float weight;
    private final float recoil;
    private final HashMap<SoundType, SoundEvent> sounds = new HashMap<>();

    public GunItem(Settings settings, Caliber caliber, float recoil, boolean automatic, int shootSpeed, int spreadAmount, float velocityMultiplier, float weight) {
        super(settings);
        this.caliber = caliber;
        this.automatic = automatic;
        this.recoil = recoil;
        this.shootSpeed = shootSpeed;
        this.spreadAmount = Math.abs(spreadAmount);
        this.velocityMultiplier = Math.max(0, velocityMultiplier);
        this.weight = 1F / weight;
        this.sounds.put(SoundType.SHOOT, SoundEvents.ENTITY_SHULKER_SHOOT);
        this.sounds.put(SoundType.RELOAD, SoundEvents.BLOCK_DISPENSER_FAIL);
    }

    public void setSound(SoundType type, SoundEvent sound) {
        this.sounds.put(type, sound);
    }

    public void addMagazineCapacity(int capacity) {
        this.magazineCapacities.add(capacity);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!automatic) {
            NbtCompound tag = stack.getTag();
            if (tag != null && tag.contains("block_usage")) {
                tag.remove("block_usage");
            }
        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        ItemStack itemStack = user.getStackInHand(hand);
        NbtCompound tag = itemStack.getTag();
        if (tag == null || (!automatic && tag.contains("block_usage")) || (!tag.contains("magazine") || !tag.contains("cartridges"))) {
            return TypedActionResult.fail(itemStack);
        }

        NbtList cartridges = tag.getList("cartridges", NbtElement.COMPOUND_TYPE);
        if (!cartridges.isEmpty()) {
            user.getItemCooldownManager().set(this, this.shootSpeed);
            tag.putBoolean("block_usage", true);
            boolean hasFired = !cartridges.isEmpty();
            if (!world.isClient) {
                NbtCompound cartridge = cartridges.getCompound(0);
                if (!user.isCreative()) {
                    cartridges.remove(0);
                }
                int amount = cartridge.contains("pellets") ? cartridge.getInt("pellets") : 1;
                for (int j = 0; j < amount; ++j) {
                    BulletEntity bulletEntity = new BulletEntity(world, user, cartridge.getFloat("damage"), cartridge.getBoolean("bullet_explosion"));
                    float yaw = user.getYaw();
                    float pitch = user.getPitch();
                    if (spreadAmount != 0) {
                        pitch += MathHelper.nextBetween(user.getRandom(), -spreadAmount, spreadAmount);
                        yaw += MathHelper.nextBetween(user.getRandom(), -spreadAmount, spreadAmount);
                    }
                    bulletEntity.setProperties(user, pitch, yaw, 0.0F, cartridge.getFloat("projectile_speed_multiplier") * velocityMultiplier * 5, 1.0F);
                    bulletEntity.setBlockLifespan(cartridge.getDouble("block_lifespan"));
                    bulletEntity.setGravity(cartridge.getBoolean("bullet_gravity"));
                    world.spawnEntity(bulletEntity);
                }
                world.playSound(null, user.getX(), user.getY(), user.getZ(), this.sounds.get(SoundType.SHOOT), SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            }

            if (hasFired) {
                user.setPitch(user.getPitch() - recoil);
            }

            user.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        return TypedActionResult.pass(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return this.shootSpeed;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public void reload(PlayerEntity player, ItemStack stack) {
        player.world.playSound(player, player.getBlockPos(), sounds.get(SoundType.RELOAD), SoundCategory.PLAYERS, 1F, 1F);
        NbtCompound tag = stack.getOrCreateTag();
        if (tag.contains("magazine")) {
            ItemStack magazineStack = new ItemStack(Registry.ITEM.get(new Identifier(tag.getString("magazine"))));
            magazineStack.setTag(tag);
            player.getInventory().offerOrDrop(magazineStack);
            stack.setTag(null);
            return;
        }
        for (int i = 0; i < player.getInventory().size(); ++i) {
            ItemStack playerStack = player.getInventory().getStack(i);
            if (playerStack.getItem() instanceof MagazineItem) {
                NbtCompound data = ((MagazineItem) playerStack.getItem()).getNbt(playerStack);
                if (!data.getString("type").equals(this.caliber.toString()) || !this.magazineCapacities.contains(data.getInt("capacity"))) {
                    continue;
                }
                stack.setTag(data);
                playerStack.decrement(1);
                if (playerStack.isEmpty()) {
                    player.getInventory().setStack(i, ItemStack.EMPTY);
                }
                break;
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound tag = stack.getTag();
        NbtList cartridges = new NbtList();
        if (tag != null){
            cartridges = tag.getList("cartridges", NbtElement.COMPOUND_TYPE);
            tooltip.add(new TranslatableText("tooltip.warhammer.capacity").append(new LiteralText("◖" + cartridges.size() + " | " + this.magazineCapacities + "◗")));
        } else {
            MutableText text = new LiteralText("[ ");
            int i = 0;
            for (int capacity : magazineCapacities) {
                text.append("" + capacity);
                if (++i < magazineCapacities.size()) {
                    text.append(", ");
                } else {
                    text.append(" ]");
                }
            }
            tooltip.add(new TranslatableText("tooltip.warhammer.capacities").append(text));
        }
        tooltip.add(new TranslatableText("tooltip.warhammer.caliber").append(new LiteralText(this.caliber.toString())));
        if (Screen.hasShiftDown()) {
            for (int i = 0; i < cartridges.size(); ++i) {
                tooltip.add(new LiteralText("⚫ " + cartridges.getCompound(i).getString("type")));
            }
        } else if (!cartridges.isEmpty()){
            tooltip.add(new TranslatableText("tooltip.warhammer.shift_for_info"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    public float getWeight() {
        return this.weight;
    }

    public enum SoundType {
        SHOOT,
        RELOAD
    }

    /*
    public float getScopeZoom(ItemStack stack) {
        if (stack == null) {
            return -1;
        }
        NbtCompound tag = stack.getTag();
        if (tag == null || tag.getInt("scope_zoom_level") <= 0 || !tag.contains("attachments", NbtElement.COMPOUND_TYPE)) {
            return -1;
        }
        tag = tag.getCompound("attachments");
        if (!tag.contains("scope", NbtElement.COMPOUND_TYPE)) {
            return -1;
        }
        tag = tag.getCompound("scope");
        return tag.getFloat("zoom_amount") * stack.getTag().getInt("scope_zoom_level");
    }

    public void tryZoom(ItemStack gun, boolean using) {
        NbtCompound tag = gun.getOrCreateTag();
        if (!tag.contains("attachments", NbtElement.COMPOUND_TYPE)) {
            return;
        }
        NbtCompound scope = tag.getCompound("attachments");
        if(!scope.contains("scope", NbtElement.COMPOUND_TYPE)) {
            return;
        }
        scope = scope.getCompound("scope");
        if (using) {
            if (!tag.getBoolean("is_zooming")) {
                int amount = (tag.getInt("scope_zoom_level") + 1) % scope.getInt("max_zoom_amount");
                tag.putInt("scope_zoom_level", amount);
            }
            tag.putBoolean("is_zooming", true);

        } else {
            tag.putBoolean("is_zooming", false);
        }
    }

    public float getMaxScopeZoom(ItemStack stack) {
        if (stack == null) {
            return 0;
        }
        NbtCompound tag = stack.getTag();
        if (tag == null || !tag.contains("attachments", NbtElement.COMPOUND_TYPE)) {
            return 0;
        }
        tag = tag.getCompound("attachments");
        if (!tag.contains("scope", NbtElement.COMPOUND_TYPE)) {
            return 0;
        }
        tag = tag.getCompound("scope");
        return tag.getInt("max_zoom_amount") * tag.getFloat("zoom_amount");
    }
    */

}
