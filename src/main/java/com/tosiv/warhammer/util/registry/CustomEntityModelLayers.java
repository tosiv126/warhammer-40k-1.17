package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.entity.BulletEntityModel;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public final class CustomEntityModelLayers {

    public static final EntityModelLayer BULLET_MODEL_LAYER = new EntityModelLayer(Utils.ID("bullet"), "main");

    public static void register() {
        EntityModelLayerRegistry.registerModelLayer(BULLET_MODEL_LAYER, BulletEntityModel::getTexturedModelData);
    }

}
