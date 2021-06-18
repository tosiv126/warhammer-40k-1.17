package com.tosiv.warhammer.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class LhoCropItem extends Item
{
    public LhoCropItem(Settings properties)
    {
        super(properties);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add((new TranslatableText("item.warhammer.lho.line1").formatted(Formatting.GREEN)));
    }
}
