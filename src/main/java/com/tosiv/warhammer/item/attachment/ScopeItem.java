package com.tosiv.warhammer.item.attachment;/*
package wraith.customizable_guns.item.attachment;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import wraith.customizable_guns.item.AttachmentItem;

public class ScopeItem extends AttachmentItem {

    public ScopeItem(Settings settings) {
        super(settings, "scope");
    }

    @Override
    public ItemStack addAttachment(ItemStack stack, ItemStack attachment) {
        NbtCompound attachmentsTag = new NbtCompound();
        NbtCompound attachmentTag = new NbtCompound();
        attachmentTag.putFloat("zoom_amount", 1F);
        attachmentTag.putInt("max_zoom_amount", 5);
        attachmentsTag.put("scope", attachmentTag);
        stack.getOrCreateTag().put("attachments", attachmentsTag);
        return stack;
    }

}
*/