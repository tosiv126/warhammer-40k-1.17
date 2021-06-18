package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.entity.BulletEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public final class EntityRegistry {

    public static EntityType<BulletEntity> BULLET;

    public static void register() {
        BULLET = Registry.register(
                Registry.ENTITY_TYPE,
                Utils.ID("bullet"),
                FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                        .dimensions(EntityDimensions
                                .fixed(0.25F, 0.25F)).trackRangeBlocks(8).build());

    }

}
