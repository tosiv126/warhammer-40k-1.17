package com.tosiv.warhammer.entity;

import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.registry.CustomEntityModelLayers;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends EntityRenderer<BulletEntity> {

    private static final Identifier TEXTURE = Utils.ID("textures/entity/bullet.png");
    private static RenderLayer LAYER = RenderLayer.getEntityTranslucent(TEXTURE);
    private final BulletEntityModel<BulletEntity> model;

    public BulletEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new BulletEntityModel<>(context.getPart(CustomEntityModelLayers.BULLET_MODEL_LAYER));
    }

    @Override
    public void render(BulletEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        matrices.scale(0.5F, 0.5F, 0.5F);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(LAYER);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1F, 1F, 1F, 1F);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(BulletEntity entity) {
        return TEXTURE;
    }

}
