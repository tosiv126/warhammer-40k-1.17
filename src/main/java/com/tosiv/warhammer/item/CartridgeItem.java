package com.tosiv.warhammer.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import com.tosiv.warhammer.util.enums.Caliber;

import java.util.List;

public class CartridgeItem extends Item {

    private final Caliber caliber;
    private final float damage;
    private final double blockLifespan;
    private final float projectileSpeedMultiplier;
    private final boolean shouldBulletHaveGravity;
    private final boolean shouldBulletExplode;
    private final int pellets;

    public CartridgeItem(Settings settings, Caliber caliber, float damage, double blockLifespan, float projectileSpeedMultiplier, boolean shouldBulletHaveGravity, boolean shouldBulletExplode, int pellets) {
        super(settings);
        this.caliber = caliber;
        this.damage = damage;
        this.blockLifespan = blockLifespan;
        this.projectileSpeedMultiplier = projectileSpeedMultiplier;
        this.shouldBulletHaveGravity = shouldBulletHaveGravity;
        this.shouldBulletExplode = shouldBulletExplode;
        this.pellets = pellets;
    }

    public NbtCompound toNbt() {
        NbtCompound nbt = new NbtCompound();
        nbt.putString("type", this.caliber.toString());
        nbt.putFloat("damage", this.damage);
        nbt.putDouble("block_lifespan", this.blockLifespan);
        nbt.putFloat("projectile_speed_multiplier", this.projectileSpeedMultiplier);
        nbt.putBoolean("bullet_gravity", this.shouldBulletHaveGravity);
        nbt.putBoolean("bullet_explosion", this.shouldBulletExplode);
        nbt.putInt("pellets", this.pellets);
        return nbt;
    }

    @Override
    public String getTranslationKey() {
        return "item.warhammer.ammo";
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.warhammer.caliber").append(this.caliber.toString()));
        tooltip.add(new TranslatableText("tooltip.warhammer.damage").append("" + this.damage));
        if (this.shouldBulletExplode) {
            tooltip.add(new TranslatableText("tooltip.warhammer.explodes"));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

}
