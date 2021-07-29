package com.tosiv.warhammer.util.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;

public class SpawnRegistry {
    @SuppressWarnings("deprecation")
    public static void register() {

        net.fabricmc.fabric.api.biome.v1.BiomeModifications.addSpawn(BiomeSelectors.categories(
                Biome.Category.DESERT, Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.UNDERGROUND),
                SpawnGroup.MONSTER,
                EntityRegistry.SCARAB, 20, 1, 5);

        net.fabricmc.fabric.api.biome.v1.BiomeModifications.addSpawn(BiomeSelectors.categories(
                Biome.Category.DESERT, Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.TAIGA, Biome.Category.JUNGLE),
                SpawnGroup.MONSTER,
                EntityRegistry.GUN_DRONE, 20, 1, 3);


    }
}