package com.tosiv.warhammer.block;

import com.tosiv.warhammer.util.registry.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class LhoCropBlock extends CropBlock {
    public LhoCropBlock(Block.Settings builder)
    {
        super(builder);
    }

    @Environment(EnvType.CLIENT)
    protected ItemConvertible getSeedsItem()
    {
        return ModItems.LHO_SEEDS;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options)
    {
        super.appendTooltip(stack, view, tooltip, options);
        tooltip.add((new TranslatableText("block.warhammer.lho_crop").formatted(Formatting.GREEN)));
    }
}
