package com.tosiv.warhammer.util.registry.item;

import com.tosiv.warhammer.util.enums.Caliber;
import com.tosiv.warhammer.GunItemGroups;
import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.item.CartridgeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class CartridgeRegistry {

    private static final HashMap<String, Item> CARTRIDGES = new HashMap<>();

    /*
    public static final CartridgeItem C4MM;
    public static final CartridgeItem C6MM;
    public static final CartridgeItem C8MM;
    public static final CartridgeItem C10MM;
    public static final CartridgeItem C12MM;
    public static final CartridgeItem G12;
    public static final CartridgeItem G12G;
    */
    public static final CartridgeItem C9MM;
    public static final CartridgeItem C19MM;

    public static void register() {
        ArrayList<String> sortedItems = new ArrayList<>(CARTRIDGES.keySet());
        sortedItems.sort(Comparator.naturalOrder());

        for (String item : sortedItems) {
            Registry.register(Registry.ITEM, Utils.ID(item), CARTRIDGES.get(item));
        }
    }

    static {

        FabricItemSettings defaultCartridgeSettings = new FabricItemSettings().group(GunItemGroups.GUNS);

        /*

        C4MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_4, 3, 200, 1, false, false, 1);
        CARTRIDGES.put("c4mm_cartridge", C4MM);

        C6MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_6, 5, 200, 1, false, false, 1);
        CARTRIDGES.put("c6mm_cartridge", C6MM);

        C8MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_8, 7, 200, 1, false, false, 1);
        CARTRIDGES.put("c8mm_cartridge", C8MM);

        C10MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_10, 9, 200, 1, false, false, 1);
        CARTRIDGES.put("c10mm_cartridge", C10MM);

        C12MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_12, 11, 300, 1, false, false, 1);
        CARTRIDGES.put("c12mm_cartridge", C12MM);

        G12 = new CartridgeItem(defaultCartridgeSettings, Caliber.GAU_12, 3, 100, 0.75F, false, false, 10);
        CARTRIDGES.put("g12_shotgun_shell", G12);

        G12G = new CartridgeItem(defaultCartridgeSettings, Caliber.GAU_12, 3, 100, 0.75F, true, true, 10);
        CARTRIDGES.put("g12g_shotgun_shell", G12G);

        */

        C9MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_9, 7, 200, 1, false, false, 1);
        CARTRIDGES.put("c9mm_cartridge", C9MM);

        C19MM = new CartridgeItem(defaultCartridgeSettings, Caliber.CAL_19, 10, 300, 1, false, false, 1);
        CARTRIDGES.put("c19mm_cartridge", C19MM);

    }

}
