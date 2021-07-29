package com.tosiv.warhammer;

import com.tosiv.warhammer.util.registry.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class NecrodermisToolMaterial implements ToolMaterial {

    public static final NecrodermisToolMaterial INSTANCE = new NecrodermisToolMaterial();

    @Override
    public int getDurability() {
        return 3000;
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
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.NECRODERMIS_INGOT);
    }
}
