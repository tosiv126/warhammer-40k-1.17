package com.tosiv.warhammer.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface ReloadableItem {

    void reload(PlayerEntity player, ItemStack stack);

}
