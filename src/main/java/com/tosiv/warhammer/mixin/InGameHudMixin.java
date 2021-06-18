package com.tosiv.warhammer.mixin;/*
package wraith.customizable_guns.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import wraith.customizable_guns.Utils;
import wraith.customizable_guns.item.GunItem;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    private static final Identifier SCOPE = Utils.ID("textures/misc/scope.png");

    @Shadow @Final private MinecraftClient client;

    @Shadow private int scaledWidth;

    @Shadow private int scaledHeight;

    @Inject(method = "renderSpyglassOverlay", at = @At("HEAD"), cancellable = true)
    private void renderScope(float scale, CallbackInfo ci) {
        Hand[] hands = Hand.values();
        PlayerEntity player = client.player;
        if (player == null) {
            return;
        }
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
        if (tag == null || tag.getInt("scope_zoom_level") <= 0) {
            return;
        }
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SCOPE);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();
        float f = (float)Math.min(this.scaledWidth, this.scaledHeight);
        float h = Math.min((float)this.scaledWidth / f, (float)this.scaledHeight / f) * scale;
        float i = f * h;
        float j = f * h;
        float k = ((float)this.scaledWidth - i) / 2.0F;
        float l = ((float)this.scaledHeight - j) / 2.0F;
        float m = k + i;
        float n = l + j;
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(k, n, -90.0D).texture(0.0F, 1.0F).next();
        bufferBuilder.vertex(m, n, -90.0D).texture(1.0F, 1.0F).next();
        bufferBuilder.vertex(m, l, -90.0D).texture(1.0F, 0.0F).next();
        bufferBuilder.vertex(k, l, -90.0D).texture(0.0F, 0.0F).next();
        tessellator.draw();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableTexture();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);
        bufferBuilder.vertex(0.0D, this.scaledHeight, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, this.scaledHeight, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(0.0D, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(0.0D, l, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, l, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, 0.0D, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(0.0D, 0.0D, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(0.0D, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(k, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(k, l, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(0.0D, l, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(m, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, n, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(this.scaledWidth, l, -90.0D).color(0, 0, 0, 255).next();
        bufferBuilder.vertex(m, l, -90.0D).color(0, 0, 0, 255).next();
        tessellator.draw();
        RenderSystem.enableTexture();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        ci.cancel();
    }

}
 */
