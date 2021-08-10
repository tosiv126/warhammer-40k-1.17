package com.tosiv.warhammer.client.model;


import com.tosiv.warhammer.entity.TauWarriorEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static com.tosiv.warhammer.Warhammer.MOD_ID;


public class TauWarriorModel extends AnimatedGeoModel<TauWarriorEntity> {
    @Override
    public Identifier getAnimationFileLocation(TauWarriorEntity entity) {
        return new Identifier(MOD_ID, "animations/tau_warrior.animation.json");
    }

    @Override
    public Identifier getModelLocation(TauWarriorEntity entity) {
        return new Identifier(MOD_ID, "geo/tau_warrior.geo.json");
    }

    @Override
    public Identifier getTextureLocation(TauWarriorEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/tau_warrior.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(TauWarriorEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 270F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}