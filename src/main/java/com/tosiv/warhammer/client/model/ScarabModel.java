package com.tosiv.warhammer.client.model;


import com.tosiv.warhammer.entity.ScarabEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static com.tosiv.warhammer.Warhammer.MOD_ID;


public class ScarabModel extends AnimatedGeoModel<ScarabEntity> {
    @Override
    public Identifier getAnimationFileLocation(ScarabEntity entity) {
        return new Identifier(MOD_ID, "animations/scarab.animation.json");
    }

    @Override
    public Identifier getModelLocation(ScarabEntity entity) {
        return new Identifier(MOD_ID, "geo/scarab.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ScarabEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/scarab.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(ScarabEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}