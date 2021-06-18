package com.tosiv.warhammer;

import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.registry.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public final class GunItemGroups {

    public static final ItemGroup GUNS = FabricItemGroupBuilder.create(Utils.ID("guns")).icon(() -> new ItemStack(ModItems.WH_ICON)).build();

}
