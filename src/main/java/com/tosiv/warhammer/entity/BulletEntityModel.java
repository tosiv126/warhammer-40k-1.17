package com.tosiv.warhammer.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class BulletEntityModel<T extends Entity> extends SinglePartEntityModel<T> {

    private final ModelPart root;
    private final ModelPart bullet;

    public BulletEntityModel(ModelPart root) {
        this.root = root;
        this.bullet = root.getChild("main");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-2F, 0.0F, -2F, 2.0F, 2.0F, 2.0F), ModelTransform.NONE);
        return TexturedModelData.of(modelData, 64, 32);
    }

    public ModelPart getPart() {
        return this.root;
    }

    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.bullet.yaw = headYaw * 0.017453292F;
        this.bullet.pitch = headPitch * 0.017453292F;
    }

}
