package com.tosiv.warhammer;

import com.tosiv.warhammer.util.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AdamantiumToolMaterial implements ToolMaterial {

    public static final AdamantiumToolMaterial INSTANCE = new AdamantiumToolMaterial();

    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 1.0f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.ADAMANTIUM_INGOT);
    }
}
