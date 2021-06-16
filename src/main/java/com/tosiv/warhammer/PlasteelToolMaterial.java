package com.tosiv.warhammer;

import com.tosiv.warhammer.util.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PlasteelToolMaterial implements ToolMaterial {

    public static final PlasteelToolMaterial INSTANCE = new PlasteelToolMaterial();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6;
    }

    @Override
    public float getAttackDamage() {
        return 4.5f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.PLASTEEL_INGOT);
    }
}
