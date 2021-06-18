package com.tosiv.warhammer.mixin;

import com.tosiv.warhammer.item.GunItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Shadow private int itemUseCooldown;

    @Shadow @Nullable public ClientPlayerEntity player;

    @Shadow @Final public GameOptions options;

    @Inject(method = "doItemUse", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/network/ClientPlayerEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void doItemUse(CallbackInfo ci, Hand[] var1, int var2, int var3, Hand hand, ItemStack itemStack) {
        if (itemStack.getItem() instanceof GunItem) {
            itemUseCooldown = 0;
        }
    }

    /*
    @Inject(method = "handleBlockBreaking", at = @At("HEAD"), cancellable = true)
    public void handleBlockBreaking(boolean bl, CallbackInfo ci) {
        ItemStack gun = getGun();
        if (gun != null) {
            ((GunItem)gun.getItem()).tryZoom(gun, bl);
            ci.cancel();
        }
    }
     */

    @Inject(method = "doAttack", at = @At("HEAD"), cancellable = true)
    public void doAttack(CallbackInfo ci) {
        if (isValidGun()) {
            ci.cancel();
        }
    }

    private boolean isValidGun() {
        ItemStack gun = getGun();
        return gun != null;
    }

    private ItemStack getGun() {
        if (player == null) {
            return null;
        }
        Hand[] hands = Hand.values();
        for (Hand hand : hands) {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getItem() instanceof GunItem) {
                return stack;
            }
        }
        return null;
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 2))
    public boolean isUsePressed1(KeyBinding keyBinding) {
        return isValidGun() ? options.keyAttack.isPressed() : keyBinding.isPressed();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 3))
    public boolean isUsePressed2(KeyBinding keyBinding) {
        return isValidGun() ? options.keyAttack.isPressed() : keyBinding.isPressed();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z", ordinal = 11))
    public boolean wasUsePressed1(KeyBinding keyBinding) {
        return isValidGun() ? options.keyAttack.wasPressed() : keyBinding.wasPressed();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z", ordinal = 14))
    public boolean wasUsePressed2(KeyBinding keyBinding) {
        return isValidGun() ? options.keyAttack.wasPressed() : keyBinding.wasPressed();
    }



    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z", ordinal = 4))
    public boolean isAttackPressed1(KeyBinding keyBinding) {
        return isValidGun() ? options.keyUse.isPressed() : keyBinding.isPressed();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z", ordinal = 10))
    public boolean wasAttackPressed1(KeyBinding keyBinding) {
        return isValidGun() ? options.keyUse.wasPressed() : keyBinding.wasPressed();
    }

    @Redirect(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/KeyBinding;wasPressed()Z", ordinal = 13))
    public boolean wasAttackPressed2(KeyBinding keyBinding) {
        return isValidGun() ? options.keyUse.wasPressed() : keyBinding.wasPressed();
    }

}
