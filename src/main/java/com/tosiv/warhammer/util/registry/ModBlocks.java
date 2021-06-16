package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CERAMITE_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 15.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final Block NETHER_CERAMITE_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 15.0f)
            .sounds(BlockSoundGroup.NETHERRACK));
    public static final Block END_CERAMITE_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 15.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final Block ADAMANTIUM_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(10.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final Block NETHER_ADAMANTIUM_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(10.0f, 20.0f)
            .sounds(BlockSoundGroup.NETHERRACK));
    public static final Block END_ADAMANTIUM_ORE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(10.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block FERROCRETE_BLOCK = new Block(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block RED_BARREL = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(2.0f, 10.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block PLASTEEL_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 15.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block COMPUTER_BLOCK = new ComputerBlock(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(2.0f, 10.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block NECRON_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(5.0f, 50.0f)
            .sounds(BlockSoundGroup.ANCIENT_DEBRIS));
    public static final Block NECRON_LIGHT_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(5.0f, 50.0f)
            .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
            .luminance(12));

    public static final Block FERROCRETE_GREEN_BLOCK = new Block(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final Block FERROCRETE_SIDE_BLOCK = new FerrocreteSideBlock(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final Block FERROCRETE_SIDE_GREEN_BLOCK = new FerrocreteSideGreenBlock(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final SlabBlock FERROCRETE_SLAB = new SlabBlock(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final SlabBlock FERROCRETE_GREEN_SLAB = new SlabBlock(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final StairsBlock FERROCRETE_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_BLOCK.getDefaultState());
    public static final StairsBlock FERROCRETE_GREEN_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_GREEN_BLOCK.getDefaultState());
    public static final Block FERROCRETE_DECORATED_BLOCK = new Block(FabricBlockSettings.copy(ModBlocks.FERROCRETE_BLOCK));
    public static final Block CERAMITE_BLOCK = new Block(FabricBlockSettings.copy(ModBlocks.PLASTEEL_BLOCK));
    public static final Block ADAMANTIUM_BLOCK = new Block(FabricBlockSettings.copy(ModBlocks.PLASTEEL_BLOCK));
    public static final Block NECRON_GLYPH_BLOCK = new NecronGlyphBlock(FabricBlockSettings.copy(ModBlocks.NECRON_BLOCK));
    public static final Block ORK_BLOCK = new Block(FabricBlockSettings.copy(ModBlocks.PLASTEEL_BLOCK));



    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "adamantium_ore_block"), ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "nether_adamantium_ore_block"), NETHER_ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "end_adamantium_ore_block"), END_ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ceramite_ore_block"), CERAMITE_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "nether_ceramite_ore_block"), NETHER_CERAMITE_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "end_ceramite_ore_block"), END_CERAMITE_ORE_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_block"), FERROCRETE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_block"), FERROCRETE_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_side_block"), FERROCRETE_SIDE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_side_green_block"), FERROCRETE_SIDE_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_slab"), FERROCRETE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_slab"), FERROCRETE_GREEN_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_stairs"), FERROCRETE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_stairs"), FERROCRETE_GREEN_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_block"), FERROCRETE_DECORATED_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "red_barrel"), RED_BARREL);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "computer_block"), COMPUTER_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_block"), NECRON_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_glyph_block"), NECRON_GLYPH_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_light_block"), NECRON_LIGHT_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ork_block"), ORK_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "plasteel_block"), PLASTEEL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ceramite_block"), CERAMITE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "adamantium_block"), ADAMANTIUM_BLOCK);

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "adamantium_ore_block"),
                new BlockItem(ADAMANTIUM_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "nether_adamantium_ore_block"),
                new BlockItem(NETHER_ADAMANTIUM_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "end_adamantium_ore_block"),
                new BlockItem(END_ADAMANTIUM_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ceramite_ore_block"),
                new BlockItem(CERAMITE_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "nether_ceramite_ore_block"),
                new BlockItem(NETHER_CERAMITE_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "end_ceramite_ore_block"),
                new BlockItem(END_CERAMITE_ORE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_block"),
                new BlockItem(FERROCRETE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_block"),
                new BlockItem(FERROCRETE_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_side_block"),
                new BlockItem(FERROCRETE_SIDE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_side_green_block"),
                new BlockItem(FERROCRETE_SIDE_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_slab"),
                new BlockItem(FERROCRETE_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_slab"),
                new BlockItem(FERROCRETE_GREEN_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_stairs"),
                new BlockItem(FERROCRETE_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_stairs"),
                new BlockItem(FERROCRETE_GREEN_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "red_barrel"),
                new BlockItem(RED_BARREL, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "plasteel_block"),
                new BlockItem(PLASTEEL_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_block"),
                new BlockItem(FERROCRETE_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ceramite_block"),
                new BlockItem(CERAMITE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "adamantium_block"),
                new BlockItem(ADAMANTIUM_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "computer_block"),
                new BlockItem(COMPUTER_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_block"),
                new BlockItem(NECRON_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_glyph_block"),
                new BlockItem(NECRON_GLYPH_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_light_block"),
                new BlockItem(NECRON_LIGHT_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ork_block"),
                new BlockItem(ORK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

    }
}
