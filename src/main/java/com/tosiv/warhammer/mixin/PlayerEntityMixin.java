package com.tosiv.warhammer.mixin;/*
package wraith.customizable_guns.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.customizable_guns.item.GunItem;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "isUsingSpyglass", at = @At("HEAD"), cancellable = true)
    public void isUsingSpyglass(CallbackInfoReturnable<Boolean> cir) {
        Hand[] hands = Hand.values();
        PlayerEntity player = (PlayerEntity)(Object)this;
        ItemStack stack = null;
        for (Hand hand : hands) {
            ItemStack currentStack = player.getStackInHand(hand);
            if (currentStack.getItem() instanceof GunItem) {
                stack = currentStack;
                break;
            }
        }
        if (stack == null) {
            return;
        }
        NbtCompound tag = stack.getTag();
        if (tag != null && tag.getInt("scope_zoom_level") > 0) {
            cir.setReturnValue(true);
        }
    }

}
*/