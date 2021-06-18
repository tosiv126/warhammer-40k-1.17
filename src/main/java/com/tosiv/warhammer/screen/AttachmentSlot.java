package com.tosiv.warhammer.screen;/*
package wraith.customizable_guns.screen;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import wraith.customizable_guns.item.AttachmentItem;

public class AttachmentSlot extends Slot {

    public AttachmentSlot(Inventory inventory, int slot, int x, int y) {
        super(inventory, slot, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (!(stack.getItem() instanceof AttachmentItem item)) {
            return false;
        }
        for (int i = 0; i < this.inventory.size(); ++i) {
            ItemStack tmpStack = this.inventory.getStack(i);
            if (tmpStack.getItem() instanceof AttachmentItem) {
                return false;
            }
        }
        return true;
    }

}
*/