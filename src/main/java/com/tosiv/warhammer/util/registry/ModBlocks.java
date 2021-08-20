package com.tosiv.warhammer.util.registry;

import com.tosiv.warhammer.Warhammer;
import com.tosiv.warhammer.block.*;
import com.tosiv.warhammer.block.BarrierBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
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
    public static final LhoCropBlock LHO_CROP = new LhoCropBlock(FabricBlockSettings
            .of(Material.PLANT)
            .noCollision()
            .ticksRandomly()
            .strength(0.0f, 0.0f)
            .sounds(BlockSoundGroup.CROP));
    public static final StatueBlock STATUE_ONE_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_TWO_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_THREE_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_ONE_GREEN_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_TWO_GREEN_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_THREE_GREEN_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_ONE_DARK_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_TWO_DARK_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));
    public static final StatueBlock STATUE_THREE_DARK_BLOCK = new StatueBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final BarrierBlock BARRIER_BLOCK = new BarrierBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final SymbolBlock SYMBOL_CHAOS_BLOCK = new SymbolBlock(FabricBlockSettings
            .of(Material.STONE)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.STONE));

    public static final Block TAU_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final Block TAU_LIGHT_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.METAL)
            .luminance(15));

    public static final Block ELDAR_BLOCK = new Block(FabricBlockSettings
            .of(Material.AMETHYST)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.BONE)
            .luminance(5));
    public static final Block ELDAR_LIGHT_BLOCK = new Block(FabricBlockSettings
            .of(Material.AMETHYST)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.BONE)
            .luminance(15));

    public static final CustomDoorBlock NECRON_DOOR_BLOCK = new CustomDoorBlock(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,3)
            .requiresTool()
            .strength(5.0f, 50.0f)
            .sounds(BlockSoundGroup.ANCIENT_DEBRIS));

    public static final CustomDoorBlock IMPERIAL_DOOR_BLOCK = new CustomDoorBlock(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,2)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.METAL));

    public static final PuritySeal PURITY_SEAL = new PuritySeal(FabricBlockSettings
            .of(Material.WOOL)
            .strength(0.5f, 1.0f)
            .sounds(BlockSoundGroup.WOOL));

    public static final Block FERROCRETE_GREEN_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_TAN_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock FERROCRETE_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock FERROCRETE_GREEN_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock FERROCRETE_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock FERROCRETE_GREEN_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_GREEN_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_GREEN_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DARK_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_TAN_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block CERAMITE_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.PLASTEEL_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block ADAMANTIUM_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.PLASTEEL_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block NECRON_GLYPH_BLOCK = new NecronGlyphBlock(FabricBlockSettings.copy(ModBlocks.NECRON_BLOCK));
    public static final Block ORK_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.PLASTEEL_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock NECRON_STAIRS = new CustomStairsBlock(ModBlocks.NECRON_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.NECRON_BLOCK)).breakByTool(FabricToolTags.PICKAXES,3));
    public static final SlabBlock NECRON_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.NECRON_BLOCK)).breakByTool(FabricToolTags.PICKAXES,3));
    public static final Block FERROCRETE_DARK_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock FERROCRETE_DARK_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock FERROCRETE_DARK_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_DARK_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock FERROCRETE_TAN_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock FERROCRETE_TAN_STAIRS = new CustomStairsBlock(ModBlocks.FERROCRETE_TAN_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final BarrierBlock BARRIER_GREEN_BLOCK = new BarrierBlock(FabricBlockSettings.copyOf((ModBlocks.BARRIER_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final BarrierBlock BARRIER_DARK_BLOCK = new BarrierBlock(FabricBlockSettings.copyOf((ModBlocks.BARRIER_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final BarrierBlock BARRIER_TAN_BLOCK = new BarrierBlock(FabricBlockSettings.copyOf((ModBlocks.BARRIER_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block TAU_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.TAU_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock TAU_STAIRS = new CustomStairsBlock(ModBlocks.TAU_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.TAU_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock TAU_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.TAU_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block ELDAR_DECORATED_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.ELDAR_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final StairsBlock ELDAR_STAIRS = new CustomStairsBlock(ModBlocks.ELDAR_BLOCK.getDefaultState(), FabricBlockSettings.copyOf((ModBlocks.ELDAR_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final SlabBlock ELDAR_SLAB = new SlabBlock(FabricBlockSettings.copyOf((ModBlocks.ELDAR_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DECORATED_2_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DECORATED_3_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_GREEN_DECORATED_2_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_GREEN_DECORATED_3_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DARK_DECORATED_2_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_DARK_DECORATED_3_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_TAN_DECORATED_2_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));
    public static final Block FERROCRETE_TAN_DECORATED_3_BLOCK = new Block(FabricBlockSettings.copyOf((ModBlocks.FERROCRETE_BLOCK)).breakByTool(FabricToolTags.PICKAXES,2));

    public static final Block IMPERIAL_FABRICATION_BENCH = new FabricationBenchBlock(FabricBlockSettings.copyOf(Blocks.SMITHING_TABLE));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "adamantium_ore_block"), ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "nether_adamantium_ore_block"), NETHER_ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "end_adamantium_ore_block"), END_ADAMANTIUM_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ceramite_ore_block"), CERAMITE_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "nether_ceramite_ore_block"), NETHER_CERAMITE_ORE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "end_ceramite_ore_block"), END_CERAMITE_ORE_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_block"), FERROCRETE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_block"), FERROCRETE_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_block"), FERROCRETE_DARK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_block"), FERROCRETE_TAN_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_slab"), FERROCRETE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_slab"), FERROCRETE_GREEN_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_slab"), FERROCRETE_DARK_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_slab"), FERROCRETE_TAN_SLAB);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_stairs"), FERROCRETE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_stairs"), FERROCRETE_GREEN_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_stairs"), FERROCRETE_DARK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_stairs"), FERROCRETE_TAN_STAIRS);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_block"), FERROCRETE_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_block"), FERROCRETE_GREEN_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_block"), FERROCRETE_DARK_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_block"), FERROCRETE_TAN_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_2_block"), FERROCRETE_DECORATED_2_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_3_block"), FERROCRETE_DECORATED_3_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_2_block"), FERROCRETE_GREEN_DECORATED_2_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_3_block"), FERROCRETE_GREEN_DECORATED_3_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_2_block"), FERROCRETE_DARK_DECORATED_2_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_3_block"), FERROCRETE_DARK_DECORATED_3_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_2_block"), FERROCRETE_TAN_DECORATED_2_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_3_block"), FERROCRETE_TAN_DECORATED_3_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "imperial_door_block"), IMPERIAL_DOOR_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_one_block"), STATUE_ONE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_two_block"), STATUE_TWO_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_three_block"), STATUE_THREE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_one_green_block"), STATUE_ONE_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_two_green_block"), STATUE_TWO_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_three_green_block"), STATUE_THREE_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_one_dark_block"), STATUE_ONE_DARK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_two_dark_block"), STATUE_TWO_DARK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "statue_three_dark_block"), STATUE_THREE_DARK_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "barrier_block"), BARRIER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "barrier_green_block"), BARRIER_GREEN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "barrier_dark_block"), BARRIER_DARK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "barrier_tan_block"), BARRIER_TAN_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "symbol_chaos_block"), SYMBOL_CHAOS_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "red_barrel"), RED_BARREL);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "computer_block"), COMPUTER_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "purity_seal"), PURITY_SEAL);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_block"), NECRON_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_glyph_block"), NECRON_GLYPH_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_light_block"), NECRON_LIGHT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_stairs"), NECRON_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_slab"), NECRON_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "necron_door_block"), NECRON_DOOR_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ork_block"), ORK_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "tau_block"), TAU_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "tau_decorated_block"), TAU_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "tau_light_block"), TAU_LIGHT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "tau_stairs"), TAU_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "tau_slab"), TAU_SLAB);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "eldar_block"), ELDAR_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "eldar_decorated_block"), ELDAR_DECORATED_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "eldar_light_block"), ELDAR_LIGHT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "eldar_stairs"), ELDAR_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "eldar_slab"), ELDAR_SLAB);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "plasteel_block"), PLASTEEL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "ceramite_block"), CERAMITE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "adamantium_block"), ADAMANTIUM_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "lho_crop"), LHO_CROP);

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
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_block"),
                new BlockItem(FERROCRETE_DARK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_block"),
                new BlockItem(FERROCRETE_TAN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_block"),
                new BlockItem(FERROCRETE_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_block"),
                new BlockItem(FERROCRETE_GREEN_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_block"),
                new BlockItem(FERROCRETE_DARK_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_block"),
                new BlockItem(FERROCRETE_TAN_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_2_block"),
                new BlockItem(FERROCRETE_DECORATED_2_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_decorated_3_block"),
                new BlockItem(FERROCRETE_DECORATED_3_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_2_block"),
                new BlockItem(FERROCRETE_GREEN_DECORATED_2_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_decorated_3_block"),
                new BlockItem(FERROCRETE_GREEN_DECORATED_3_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_2_block"),
                new BlockItem(FERROCRETE_DARK_DECORATED_2_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_decorated_3_block"),
                new BlockItem(FERROCRETE_DARK_DECORATED_3_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_2_block"),
                new BlockItem(FERROCRETE_TAN_DECORATED_2_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_decorated_3_block"),
                new BlockItem(FERROCRETE_TAN_DECORATED_3_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_slab"),
                new BlockItem(FERROCRETE_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_slab"),
                new BlockItem(FERROCRETE_GREEN_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_slab"),
                new BlockItem(FERROCRETE_DARK_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_slab"),
                new BlockItem(FERROCRETE_TAN_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_stairs"),
                new BlockItem(FERROCRETE_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_green_stairs"),
                new BlockItem(FERROCRETE_GREEN_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_dark_stairs"),
                new BlockItem(FERROCRETE_DARK_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ferrocrete_tan_stairs"),
                new BlockItem(FERROCRETE_TAN_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "barrier_block"),
                new BlockItem(BARRIER_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "barrier_green_block"),
                new BlockItem(BARRIER_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "barrier_dark_block"),
                new BlockItem(BARRIER_DARK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "barrier_tan_block"),
                new BlockItem(BARRIER_TAN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_one_block"),
                new BlockItem(STATUE_ONE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_two_block"),
                new BlockItem(STATUE_TWO_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_three_block"),
                new BlockItem(STATUE_THREE_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_one_green_block"),
                new BlockItem(STATUE_ONE_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_two_green_block"),
                new BlockItem(STATUE_TWO_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_three_green_block"),
                new BlockItem(STATUE_THREE_GREEN_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_one_dark_block"),
                new BlockItem(STATUE_ONE_DARK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_two_dark_block"),
                new BlockItem(STATUE_TWO_DARK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "statue_three_dark_block"),
                new BlockItem(STATUE_THREE_DARK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "imperial_door_block"),
                new BlockItem(IMPERIAL_DOOR_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "symbol_chaos_block"),
                new BlockItem(SYMBOL_CHAOS_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "plasteel_block"),
                new BlockItem(PLASTEEL_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
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
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_stairs"),
                new BlockItem(NECRON_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_slab"),
                new BlockItem(NECRON_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "necron_door_block"),
                new BlockItem(NECRON_DOOR_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "tau_block"),
                new BlockItem(TAU_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "tau_decorated_block"),
                new BlockItem(TAU_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "tau_light_block"),
                new BlockItem(TAU_LIGHT_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "tau_stairs"),
                new BlockItem(TAU_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "tau_slab"),
                new BlockItem(TAU_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "eldar_block"),
                new BlockItem(ELDAR_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "eldar_decorated_block"),
                new BlockItem(ELDAR_DECORATED_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "eldar_light_block"),
                new BlockItem(ELDAR_LIGHT_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "eldar_stairs"),
                new BlockItem(ELDAR_STAIRS, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "eldar_slab"),
                new BlockItem(ELDAR_SLAB, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));

        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "ork_block"),
                new BlockItem(ORK_BLOCK, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "red_barrel"),
                new BlockItem(RED_BARREL, new FabricItemSettings().group(Warhammer.GENERAL_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "purity_seal"),
                new BlockItem(PURITY_SEAL, new FabricItemSettings().group(Warhammer.WIP_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier(Warhammer.MOD_ID, "imperial_fabrication_bench"), IMPERIAL_FABRICATION_BENCH);
        Registry.register(Registry.ITEM, new Identifier(Warhammer.MOD_ID, "imperial_fabrication_bench"), new BlockItem(IMPERIAL_FABRICATION_BENCH, new FabricItemSettings().group(Warhammer.WIP_GROUP)));
    }
}
