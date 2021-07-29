package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.*;
import com.tosiv.warhammer.item.CustomPickaxeItem;
import com.tosiv.warhammer.item.LhoCropItem;
import com.tosiv.warhammer.item.LhoSeedsItem;
import com.tosiv.warhammer.item.SmokedItem;
import net.minecraft.item.*;
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
    public static final Item NECRODERMIS_INGOT = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));
    public static final Item FIOTAK_INGOT = new Item(new Item.Settings()
            .group(Warhammer.GENERAL_GROUP)
            .rarity(Rarity.COMMON));

    //Drugs
    public static final SmokedItem LHO_STICK = new SmokedItem(new Item.Settings()
            .group(Warhammer.WIP_GROUP)
            .food(new FoodComponent.Builder()
                    .hunger(0)
                    .saturationModifier(4.0f)
                    .alwaysEdible()
                    .build()));

    //Seeds
    public static final LhoSeedsItem LHO_SEEDS = new LhoSeedsItem(ModBlocks.LHO_CROP, (new Item.Settings().group(Warhammer.WIP_GROUP)));

    //Crop Items
    public static final LhoCropItem LHO_LEAF = new LhoCropItem((new Item.Settings().group(Warhammer.WIP_GROUP)));

    //Tools
    public static ToolItem PLASTEEL_PICKAXE = new CustomPickaxeItem(PlasteelToolMaterial.INSTANCE, 2, -2.8f, new Item.Settings().group(Warhammer.GENERAL_GROUP));
    public static ToolItem COMBAT_KNIFE = new SwordItem(PlasteelToolMaterial.INSTANCE, 4, -2.4F, new Item.Settings().group(Warhammer.GENERAL_GROUP));
    public static ToolItem ENTRENCHING_TOOL = new ShovelItem(PlasteelToolMaterial.INSTANCE, 3, -3.0F, new Item.Settings().group(Warhammer.GENERAL_GROUP));
    public static ToolItem IG_CHAINSWORD = new SwordItem(CeramiteToolMaterial.INSTANCE, 5, -2.4F, new Item.Settings().group(Warhammer.GENERAL_GROUP));
    public static ToolItem THUNDER_HAMMER = new SwordItem(AdamantiumToolMaterial.INSTANCE, 10, -3.4F, new Item.Settings().group(Warhammer.GENERAL_GROUP));
    public static ToolItem HYPERPHASE_SWORD = new SwordItem(NecrodermisToolMaterial.INSTANCE, 6, -1.5F, new Item.Settings().group(Warhammer.GENERAL_GROUP));

    public static final Item WH_ICON = new Item(new Item.Settings());


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "nutrient_paste"), NUTRIENT_PASTE);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_adamantium"), RAW_ADAMANTIUM);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_ceramite"), RAW_CERAMITE);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "raw_plasteel"), RAW_PLASTEEL);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "adamantium_ingot"), ADAMANTIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ceramite_ingot"), CERAMITE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "plasteel_ingot"), PLASTEEL_INGOT);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necrodermis_ingot"), NECRODERMIS_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "fiotak_ingot"), FIOTAK_INGOT);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"plasteel_pickaxe"), PLASTEEL_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"combat_knife"), COMBAT_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"entrenching_tool"), ENTRENCHING_TOOL);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"ig_chainsword"), IG_CHAINSWORD);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"thunder_hammer"), THUNDER_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID,"hyperphase_sword"), HYPERPHASE_SWORD);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "lho_seeds"), LHO_SEEDS);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "lho_leaf"), LHO_LEAF);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "lho_stick"), LHO_STICK);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "wh_icon"), WH_ICON);
    }


}