package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.crafting.FabricationBenchRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class ModRecipes {

    public static final RecipeType<FabricationBenchRecipe> FABRICATION_BENCH = new RecipeType<>() {
        @Override
        public String toString() {
            return "fabrication_bench";
        }
    };
    public static final RecipeSerializer<FabricationBenchRecipe> FABRICATION_BENCH_SERIALIZER = new FabricationBenchRecipe.Serializer();

    public static void register() {
        Registry.register(Registry.RECIPE_TYPE, Warhammer.MOD_ID("fabrication_bench"), FABRICATION_BENCH);
        Registry.register(Registry.RECIPE_SERIALIZER, Warhammer.MOD_ID("fabrication_bench"), FABRICATION_BENCH_SERIALIZER);
    }
}
