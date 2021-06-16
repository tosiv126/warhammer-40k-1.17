package com.tosiv.warhammer.world;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.util.registry.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class OreGeneration {

    public static ConfiguredFeature<?, ?> ORE_CERAMITE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.CERAMITE_ORE_BLOCK.getDefaultState(),
                    9))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(
                    YOffset.fixed(0),
                    YOffset.fixed(60)
            ))))
            .spreadHorizontally()
            .repeat(10);
    public static ConfiguredFeature<?, ?> ORE_ADAMANTIUM_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.ADAMANTIUM_ORE_BLOCK.getDefaultState(),
                    4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(
                    YOffset.fixed(0),
                    YOffset.fixed(20)
            ))))
            .spreadHorizontally()
            .repeat(2);
    public static ConfiguredFeature<?, ?> ORE_CLAY_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Blocks.CLAY.getDefaultState(),
                    10))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(
                    YOffset.fixed(0),
                    YOffset.fixed(60)
            ))))
            .spreadHorizontally()
            .repeat(20);

    public static void register() {
        RegistryKey<ConfiguredFeature<?, ?>> oreCeramiteOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Warhammer.MOD_ID, "ore_ceramite_overworld"));
        RegistryKey<ConfiguredFeature<?, ?>> oreAdamantiumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Warhammer.MOD_ID, "ore_adamantium_overworld"));
        RegistryKey<ConfiguredFeature<?, ?>> oreClayOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(Warhammer.MOD_ID, "ore_clay_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCeramiteOverworld.getValue(), ORE_CERAMITE_OVERWORLD);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAdamantiumOverworld.getValue(), ORE_ADAMANTIUM_OVERWORLD);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreClayOverworld.getValue(), ORE_CLAY_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCeramiteOverworld);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreAdamantiumOverworld);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreClayOverworld);
    }
}
