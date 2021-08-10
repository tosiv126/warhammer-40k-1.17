package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.entity.*;
import com.tosiv.warhammer.util.Utils;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class EntityRegistry {


    public static final EntityType<ScarabEntity> SCARAB = Registry.register(Registry.ENTITY_TYPE, new Identifier(Warhammer.MOD_ID, "scarab"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScarabEntity::new).dimensions(EntityDimensions.fixed(0.9F, 0.5F)).build());
    public static final EntityType<GunDroneEntity> GUN_DRONE = Registry.register(Registry.ENTITY_TYPE, new Identifier(Warhammer.MOD_ID, "gun_drone"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GunDroneEntity::new).dimensions(EntityDimensions.fixed(0.9F, 0.9F)).build());
    public static final EntityType<TauWarriorEntity> TAU_WARRIOR = Registry.register(Registry.ENTITY_TYPE, new Identifier(Warhammer.MOD_ID, "tau_warrior"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TauWarriorEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.9F)).build());
    public static final EntityType<IgChainswordVillagerEntity> IG_CHAINSWORD_VILLAGER = Registry.register(Registry.ENTITY_TYPE, new Identifier(Warhammer.MOD_ID, "ig_chainsword_villager"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IgChainswordVillagerEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.9F)).build());
    public static EntityType<BulletEntity> BULLET;

    public static void register() {

        FabricDefaultAttributeRegistry.register(SCARAB, ScarabEntity.createScarabAttributes());
        FabricDefaultAttributeRegistry.register(GUN_DRONE, GunDroneEntity.createGunDroneAttributes());
        FabricDefaultAttributeRegistry.register(TAU_WARRIOR, TauWarriorEntity.createTauWarriorAttributes());
        FabricDefaultAttributeRegistry.register(IG_CHAINSWORD_VILLAGER, IgChainswordVillagerEntity.createIgChainswordVillagerAttributes());
        BULLET = Registry.register(
                Registry.ENTITY_TYPE,
                Utils.ID("bullet"),
                FabricEntityTypeBuilder.<BulletEntity>create(SpawnGroup.MISC, BulletEntity::new)
                        .dimensions(EntityDimensions
                                .fixed(0.25F, 0.25F)).trackRangeBlocks(8).build());

    }

}
