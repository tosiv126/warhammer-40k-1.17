package com.tosiv.warhammer.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

public class CustomStairsBlock extends StairsBlock {

    public CustomStairsBlock(BlockState state) {
        super(state, FabricBlockSettings.copy(state.getBlock()));
    }
}
