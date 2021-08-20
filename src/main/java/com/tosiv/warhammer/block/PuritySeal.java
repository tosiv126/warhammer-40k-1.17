package com.tosiv.warhammer.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PuritySeal extends HorizontalFacingBlock {
    public PuritySeal(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.cuboid(0.375f, 0.625f, 0.1875f, 0.6875f, 1.0f, 0.8125f);
            case SOUTH:
                return VoxelShapes.cuboid(0.3125f, 0.625f, 0.1875f, 0.6875f, 1.0f, 0.8125f);
            case EAST:
                return VoxelShapes.cuboid(0.1875f, 0.625f, 0.0f, 0.8125f, 1.0f, 1.0f);
            case WEST:
                return VoxelShapes.cuboid(0.1875f, 0.625f, 0.0f, 0.8125f, 1.0f, 1.0f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

}