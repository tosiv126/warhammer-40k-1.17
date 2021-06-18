package com.tosiv.warhammer.mixin;/*
package wraith.customizable_guns.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wraith.customizable_guns.Ayo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Shadow @Final private MinecraftClient client;

    @Shadow private float movementFovMultiplier;

    @Shadow private float lastMovementFovMultiplier;

    @Inject(method = "updateMovementFovMultiplier", at = @At("RETURN"), cancellable = true)
    public void updateMovementFovMultiplier(CallbackInfo ci) {
        PlayerEntity player = this.client.player;
        if (player == null) {
            return;
        }

        this.movementFovMultiplier = TemporaryClass.temp1(player, this.lastMovementFovMultiplier, this.movementFovMultiplier);
    }

    @ModifyVariable(method = "getFov", at = @At(value = "TAIL", shift = At.Shift.BEFORE))
    public double getFov(double fov, Camera camera, float tickDelta, boolean changingFov) {
        PlayerEntity player = this.client.player;
        if (player == null) {
            return fov;
        }
        return TemporaryClass.temp2(player, fov, tickDelta);
    }

}
*/