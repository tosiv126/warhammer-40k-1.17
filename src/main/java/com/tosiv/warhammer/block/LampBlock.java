package com.tosiv.warhammer.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LampBlock extends Block {
    public LampBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        //return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 0.6875f, 1.0f);
        final VoxelShape MIDDLE = Block.createCuboidShape(4,1,4,12,15,12);
        final VoxelShape TOP = Block.createCuboidShape(5,15,5,11,16,11);
        final VoxelShape BOTTOM = Block.createCuboidShape(5,0,5,11,1,11);
        final VoxelShape ALL = VoxelShapes.union(MIDDLE, TOP, BOTTOM);
        return ALL;
    }
}
