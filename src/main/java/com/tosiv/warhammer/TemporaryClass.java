package com.tosiv.warhammer;/*
package wraith.customizable_guns;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import wraith.customizable_guns.item.GunItem;

public class TemporaryClass {


    public static float temp1(PlayerEntity player, float lastMovementFovMultiplier, float movementFovMultiplier) {
        /*
        float zoom = -1;
        ItemStack currentStack = player.getMainHandStack();
        if (currentStack.getItem() instanceof GunItem && ((GunItem)currentStack.getItem()).getScopeZoom(currentStack) != -1) {
            zoom = ((GunItem)currentStack.getItem()).getScopeZoom(currentStack) / ((GunItem)currentStack.getItem()).getMaxScopeZoom(currentStack);
        }
        if (zoom == -1) {
            return movementFovMultiplier;
        }
        zoom = 1.5F - zoom * 1.5F;
        //zoom *= lastMovementFovMultiplier;
        return MathHelper.clamp(zoom - lastMovementFovMultiplier, 0.1F, 1.5F);
         //
        return movementFovMultiplier;
    }

    public static double temp2(PlayerEntity player, double fov, double dt) {
        float zoom = -1;
        float oldZoom = -1;
        ItemStack currentStack = player.getMainHandStack();
        if (currentStack.getItem() instanceof GunItem && ((GunItem)currentStack.getItem()).getScopeZoom(currentStack) != -1) {
            zoom = ((GunItem)currentStack.getItem()).getScopeZoom(currentStack) / ((GunItem)currentStack.getItem()).getMaxScopeZoom(currentStack);
            oldZoom = (((GunItem)currentStack.getItem()).getScopeZoom(currentStack) - 1) / ((GunItem)currentStack.getItem()).getMaxScopeZoom(currentStack);
        }
        if (zoom == -1) {
            return fov;
        }

        return fov + (1 - zoom) * 100;
    }

}
*/