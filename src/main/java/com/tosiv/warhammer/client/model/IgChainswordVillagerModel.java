package com.tosiv.warhammer.client.model;


import com.tosiv.warhammer.entity.IgChainswordVillagerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static com.tosiv.warhammer.Warhammer.MOD_ID;


public class IgChainswordVillagerModel extends AnimatedGeoModel<IgChainswordVillagerEntity> {
    @Override
    public Identifier getAnimationFileLocation(IgChainswordVillagerEntity entity) {
        return new Identifier(MOD_ID, "animations/ig_chainsword_villager.animation.json");
    }

    @Override
    public Identifier getModelLocation(IgChainswordVillagerEntity entity) {
        return new Identifier(MOD_ID, "geo/ig_chainsword_villager.geo.json");
    }

    @Override
    public Identifier getTextureLocation(IgChainswordVillagerEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/ig_chainsword_villager.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(IgChainswordVillagerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 270F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}