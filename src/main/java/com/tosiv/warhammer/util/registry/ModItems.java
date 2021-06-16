package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.PlasteelToolMaterial;
import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.item.CustomPickaxeItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item NUTRIENT_PASTE = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .food(new FoodComponent.Builder()
                    .hunger(8)
                    .saturationModifier(6.0f)
                    .build()));
    public static final Item RAW_ADAMANTIUM = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON)
            .fireproof());
    public static final Item RAW_CERAMITE = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item RAW_PLASTEEL = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item ADAMANTIUM_INGOT = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON)
            .fireproof());
    public static final Item CERAMITE_INGOT = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item PLASTEEL_INGOT = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item BULLET = new Item(new Item.Settings()
            .group(Warhammer.AMMO_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item BOLTER_ROUND = new Item(new Item.Settings()
            .group(Warhammer.AMMO_GROUP)
            .rarity(Rarity.COMMON));


    //Tools
    public static ToolItem PLASTEEL_PICKAXE = new CustomPickaxeItem(PlasteelToolMaterial.INSTANCE, 1, -2.8f, new Item.Settings().group(Warhammer.GENERAL_GROUP));

    public static final Item WH_ICON = new Item(new Item.Settings());


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "nutrient_paste"), NUTRIENT_PASTE);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_adamantium"), RAW_ADAMANTIUM);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_ceramite"), RAW_CERAMITE);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_plasteel"), RAW_PLASTEEL);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "adamantium_ingot"), ADAMANTIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ceramite_ingot"), CERAMITE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "plasteel_ingot"), PLASTEEL_INGOT);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"plasteel_pickaxe"), PLASTEEL_PICKAXE);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"bolter_round"), BOLTER_ROUND);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"bullet"), BULLET);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "wh_icon"), WH_ICON);
    }


}