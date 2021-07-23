package com.tosiv.warhammer.item;

import com.tosiv.warhammer.util.enums.Caliber;
import com.tosiv.warhammer.util.registry.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagazineItem extends Item implements ReloadableItem {

    private final Caliber caliber;
    private final int maxCapacity;

    public MagazineItem(Settings settings, Caliber caliber, int maxCapacity) {
        super(settings);
        this.caliber = caliber;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void reload(PlayerEntity player, ItemStack stack) {
        player.world.playSound(player, player.getBlockPos(), ModSounds.RELOAD_EVENT, SoundCategory.PLAYERS, 1F, 1F);
        NbtCompound tag = stack.getOrCreateTag();
        NbtList cartridges;
        if (tag.contains("cartridges")) {
            cartridges = tag.getList("cartridges", NbtCompound.COMPOUND_TYPE);
        } else {
            cartridges = new NbtList();
        }

        if (cartridges.size() >= this.maxCapacity) {
            return;
        }

        for (int i = 0; i < player.getInventory().size(); ++i) {
            ItemStack playerStack = player.getInventory().getStack(i);
            if (playerStack.getItem() instanceof CartridgeItem) {
                NbtCompound data = ((CartridgeItem) playerStack.getItem()).toNbt();
                if (!data.getString("type").equals(this.caliber.toString())) {
                    continue;
                }
                cartridges.add(data);
                playerStack.decrement(1);
                if (playerStack.isEmpty()) {
                    player.getInventory().setStack(i, ItemStack.EMPTY);
                }
                break;
            }
        }
        tag.put("cartridges", cartridges);
    }

    public NbtCompound toTag() {
        NbtCompound nbt = new NbtCompound();
        nbt.putString("magazine", Registry.ITEM.getId(this).toString());
        nbt.putString("type", this.caliber.toString());
        nbt.putInt("capacity", this.maxCapacity);
        nbt.put("cartridges", new NbtList());
        return nbt;
    }

    public NbtCompound getNbt(ItemStack stack) {
        NbtCompound tag = stack.getOrCreateTag();
        NbtCompound defaultTag = toTag();
        if (tag.contains("magazine")) {
            defaultTag.putString("magazine", tag.getString("magazine"));
        }
        if (tag.contains("type")) {
            defaultTag.putString("type", tag.getString("type"));
        }
        if (tag.contains("capacity")) {
            defaultTag.putInt("capacity", tag.getInt("capacity"));
        }
        if (tag.contains("cartridges")) {
            defaultTag.put("cartridges", tag.getList("cartridges", NbtElement.COMPOUND_TYPE));
        }
        return defaultTag;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound tag = getNbt(stack);
        NbtList cartridges = tag.getList("cartridges", NbtElement.COMPOUND_TYPE);
        tooltip.add(new TranslatableText("tooltip.warhammer.capacity").append(new LiteralText("[" + cartridges.size() + " | " + this.maxCapacity + "]")));
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

    @Override
    public String getTranslationKey() {
        return "item.warhammer.magazine";
    }

}
