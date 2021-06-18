package com.tosiv.warhammer.screen;/*
package wraith.customizable_guns.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import wraith.customizable_guns.item.GunItem;
import wraith.customizable_guns.registry.GunScreenHandlerRegistry;

public class WeaponsTableScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public WeaponsTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(5));
    }

    public WeaponsTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(GunScreenHandlerRegistry.WEAPONS_TABLE, syncId);

        this.inventory = inventory;

        int invX = 8;
        int invY = 119;

        //Top
        this.addSlot(new AttachmentSlot(inventory, 0, 80, 20));
        //Left
        this.addSlot(new AttachmentSlot(inventory, 1, 50, 50));
        //Right
        this.addSlot(new AttachmentSlot(inventory, 2, 110, 50));
        //Bottom
        this.addSlot(new AttachmentSlot(inventory, 3, 80, 80));

        //Center
        this.addSlot(new Slot(inventory, 4, 80, 50) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() instanceof GunItem;
            }
        });

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlot(new Slot(playerInventory, x + y * 9 + 9, invX + x * 18, invY + y * 18));
            }
        }
        for (int x = 0; x < 9; ++x) {
            this.addSlot(new Slot(playerInventory, x, invX + x * 18, invY + 58));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void getRemovePacket(NbtList slot, ItemStack gun) {
        for (int i = 0; i < slot.size(); ++i) {
            this.getSlot(slot.getInt(i)).getStack().decrement(1);
            if (this.getSlot(slot.getInt(i)).getStack().isEmpty()) {
                this.getSlot(slot.getInt(i)).setStack(ItemStack.EMPTY);
            }
        }
        this.getSlot(4).setStack(gun);
        this.inventory.markDirty();
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            int invSize = this.inventory.size();
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < invSize) {
                if (!this.insertItem(originalStack, invSize, this.slots.size(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, invSize - 1, false)) {
                if (invSlot < this.slots.size() - 9) {
                    if (!this.insertItem(originalStack, this.slots.size() - 9, this.slots.size(), false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (invSlot >= this.slots.size() - 9) {
                    if (!this.insertItem(originalStack, invSize, this.slots.size() - 9, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    return ItemStack.EMPTY;
                }
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (originalStack.getCount() == newStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(player, originalStack);
        }

        return newStack;

    }


}
 */
