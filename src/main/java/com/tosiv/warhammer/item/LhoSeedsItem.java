package com.tosiv.warhammer.item;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class LhoSeedsItem extends BlockItem
{
    public LhoSeedsItem(Block crop, Settings builder)
    {
        super(crop, builder);
    }

    @Override
    public String getTranslationKey() {
        return "item.warhammer.lho_seeds";
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add((new TranslatableText("item.warhammer.lho_seeds.line1").formatted(Formatting.GREEN)));
    }
}
