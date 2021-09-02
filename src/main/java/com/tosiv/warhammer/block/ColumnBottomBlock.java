package com.tosiv.warhammer.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ColumnBottomBlock extends Block {
    public ColumnBottomBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        //return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.6875f, 1.0f);
        final VoxelShape MIDDLE = Block.createCuboidShape(1,0,1,15,16,15);
        final VoxelShape BOTTOM = Block.createCuboidShape(0,0,0,16,2,16);
        final VoxelShape ALL = VoxelShapes.union(MIDDLE, BOTTOM);
        return ALL;
    }
}
