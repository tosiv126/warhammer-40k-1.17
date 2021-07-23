package com.tosiv.warhammer.client.renderer;

import com.tosiv.warhammer.client.model.ScarabModel;
import com.tosiv.warhammer.entity.ScarabEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.geo.render.built.GeoModel;

public class ScarabRenderer extends GeoMobRenderer<ScarabEntity> {
    public ScarabRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ScarabModel());
    }

    @Override
    public RenderLayer getRenderType(ScarabEntity animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void render(GeoModel model, ScarabEntity animatable, float partialTicks, RenderLayer type,
                       MatrixStack matrixStackIn, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                       int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

        super.render(model, animatable, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder,
                packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
