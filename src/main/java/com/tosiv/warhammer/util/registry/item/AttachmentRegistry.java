package com.tosiv.warhammer.util.registry.item;/*
package wraith.customizable_guns.registry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import wraith.customizable_guns.GunItemGroups;
import wraith.customizable_guns.Utils;
import wraith.customizable_guns.item.AttachmentItem;
import wraith.customizable_guns.item.attachment.ScopeItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class AttachmentRegistry {

    private static HashMap<String, Item> ATTACHMENTS = new HashMap<>();

    public static final AttachmentItem SCOPE;

    public static void register() {
        ArrayList<String> sortedItems = new ArrayList<>(ATTACHMENTS.keySet());
        sortedItems.sort(Comparator.naturalOrder());

        for (String item : sortedItems) {
            Registry.register(Registry.ITEM, Utils.ID(item), ATTACHMENTS.get(item));
        }
    }

    static {

        FabricItemSettings defaultAttachmentSettings = new FabricItemSettings().group(GunItemGroups.GUNS).maxCount(1);

        SCOPE = new ScopeItem(defaultAttachmentSettings);
        ATTACHMENTS.put("scope_attachment", SCOPE);

    }

}
*/