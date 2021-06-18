package com.tosiv.warhammer.mixin;/*
package wraith.customizable_guns.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wraith.customizable_guns.item.GunItem;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin {

    @Inject(method = "getSpeed", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;getActiveItem()Lnet/minecraft/item/ItemStack;"), cancellable = true)
    public void getSpeed(CallbackInfoReturnable<Float> cir) {
        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity)(Object)this;
        ItemStack currentStack = player.getMainHandStack();
        if (currentStack.getItem() instanceof GunItem) {
            float zoom = ((GunItem)currentStack.getItem()).getScopeZoom(currentStack);
            if (zoom != -1) {
                cir.setReturnValue(0.1F);
                cir.cancel();
            }
        }
    }

}
*/