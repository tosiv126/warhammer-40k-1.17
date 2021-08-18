package com.tosiv.warhammer.mixin;

import com.tosiv.warhammer.client.ScalableItemRenderer;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin implements ScalableItemRenderer {

    @Unique
    @Nullable
    private Vec3f scale = null;

    @Override
    public void setScale(@Nullable Vec3f scale) {
        this.scale = scale;
    }

    @Nullable
    @Override
    public Vec3f getScale() {
        return scale;
    }

    @Override
    public void clearScale() {
        setScale(null);
    }

    @Inject(method = "renderGuiItemModel", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;applyModelViewMatrix()V", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onRenderFirst(ItemStack stack, int x, int y, BakedModel model, CallbackInfo ci, MatrixStack matrices) {
        Vec3f scale = getScale();
        if(scale != null) {
            matrices.scale(scale.getX(), scale.getY(), scale.getZ());
        }
    }

    @Inject(method = "renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
    private void onRenderGuiItemOverlay(TextRenderer renderer, ItemStack stack, int x, int y, String countLabel, CallbackInfo ci, MatrixStack matrices) {
        Vec3f scale = getScale();
        if (scale != null) {
            matrices.scale(scale.getX(), scale.getY(), scale.getZ());
        }
    }
}
