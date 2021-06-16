package com.tosiv.warhammer;

import com.tosiv.warhammer.util.registry.ModBlocks;
import com.tosiv.warhammer.util.registry.ModItems;
import com.tosiv.warhammer.util.registry.ModSounds;
import com.tosiv.warhammer.world.OreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Warhammer implements ModInitializer {

    public static final String MOD_ID = "warhammer";

    public static final ItemGroup GENERAL_GROUP = FabricItemGroupBuilder.create(
            new Identifier("warhammer", "general"))
            .icon(() -> new ItemStack(ModItems.NUTRIENT_PASTE)).build();
    public static final ItemGroup WEAPON_GROUP = FabricItemGroupBuilder.create(
            new Identifier("warhammer", "weapons"))
            .icon(() -> new ItemStack(ModItems.WH_ICON)).build();
    public static final ItemGroup AMMO_GROUP = FabricItemGroupBuilder.create(
            new Identifier("warhammer", "ammo"))
            .icon(() -> new ItemStack(ModItems.BULLET)).build();


    @Override
    public void onInitialize() {

        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModSounds.registerSounds();
        OreGeneration.register();
    }
}
