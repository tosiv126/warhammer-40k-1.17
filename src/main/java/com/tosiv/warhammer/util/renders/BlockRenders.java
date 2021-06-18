package com.tosiv.warhammer.util.renders;

import com.tosiv.warhammer.util.registry.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BlockRenders {

    public static void defineRenders()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LHO_CROP, RenderLayer.getCutoutMipped());
    }
}
