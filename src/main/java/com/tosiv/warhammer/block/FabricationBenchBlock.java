package com.tosiv.warhammer.block;

import com.tosiv.warhammer.screen.FabricationBenchScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FabricationBenchBlock extends HorizontalFacingBlock {

    public static final Property<Direction> FACING = HorizontalFacingBlock.FACING;

    public FabricationBenchBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        //return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.6875f, 1.0f);
        final VoxelShape BASE = Block.createCuboidShape(0,0,0,16,1,16);
        final VoxelShape TOP = Block.createCuboidShape(0,10,0,16,11,16);
        final VoxelShape MIDDLE = Block.createCuboidShape(1,1,1,15,10,15);
        final VoxelShape ALL = VoxelShapes.union(BASE, TOP, MIDDLE);
        return ALL;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
            // TODO increment interact stat
            // player.incrementStat(ModStats.FABRICATION_TABLE_INTERACT);
            return ActionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new FabricationBenchScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), FabricationBenchScreenHandler.TITLE);
    }
}
