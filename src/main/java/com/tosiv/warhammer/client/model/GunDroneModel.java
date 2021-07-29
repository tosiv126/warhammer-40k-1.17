package com.tosiv.warhammer.client.model;


import com.tosiv.warhammer.entity.GunDroneEntity;
import com.tosiv.warhammer.entity.ScarabEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static com.tosiv.warhammer.Warhammer.MOD_ID;


public class GunDroneModel extends AnimatedGeoModel<GunDroneEntity> {
    @Override
    public Identifier getAnimationFileLocation(GunDroneEntity entity) {
        return new Identifier(MOD_ID, "animations/gun_drone.animation.json");
    }

    @Override
    public Identifier getModelLocation(GunDroneEntity entity) {
        return new Identifier(MOD_ID, "geo/gun_drone.geo.json");
    }

    @Override
    public Identifier getTextureLocation(GunDroneEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/gun_drone.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(GunDroneEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("gun_mount");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 270F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}