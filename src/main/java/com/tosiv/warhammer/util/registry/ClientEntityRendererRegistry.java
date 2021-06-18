package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.entity.BulletEntityRenderer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public final class ClientEntityRendererRegistry {

    public static void register() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.BULLET, BulletEntityRenderer::new);
    }

}
