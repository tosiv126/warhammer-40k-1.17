package com.tosiv.warhammer.mixin;

import com.tosiv.warhammer.item.GunItem;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Shadow public Input input;

    @Inject(method = "tickMovement", at = @At(value = "FIELD", target = "Lnet/minecraft/client/network/ClientPlayerEntity;ticksLeftToDoubleTapSprint:I", ordinal = 3), locals = LocalCapture.CAPTURE_FAILSOFT)
    public void tickMovement(CallbackInfo ci, boolean bl, boolean bl2, boolean bl3) {
        ClientPlayerEntity player = (ClientPlayerEntity)(Object)this;
        Hand[] hands = Hand.values();
        float weight = -1;
        for (Hand hand : hands) {
            Item item = player.getStackInHand(hand).getItem();
            if (item instanceof GunItem) {
                weight = ((GunItem)item).getWeight();
                break;
            }
        }
        if (weight != -1) {
            input.movementSideways *= 5 * weight;
            input.movementForward *= 5 * weight;
        }
    }

}
