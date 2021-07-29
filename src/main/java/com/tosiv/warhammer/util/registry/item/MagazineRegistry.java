package com.tosiv.warhammer.util.registry.item;

import com.tosiv.warhammer.GunItemGroups;
import com.tosiv.warhammer.item.MagazineItem;
import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.util.enums.Caliber;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class MagazineRegistry {

    private static final HashMap<String, Item> MAGAZINES = new HashMap<>();

    /*
    public static final MagazineItem C8MM_S6_MAGAZINE;
    public static final MagazineItem C8MM_S8_MAGAZINE;
    public static final MagazineItem C8MM_S12_MAGAZINE;
    public static final MagazineItem C12MM_S8_MAGAZINE;
    public static final MagazineItem C12MM_S12_MAGAZINE;
    public static final MagazineItem G12_S8_BOX_MAGAZINE;
    public static final MagazineItem G12_S20_DRUM_MAGAZINE;
     */

    public static final MagazineItem C9MM_S20_MAGAZINE;
    public static final MagazineItem BOLT_S12_MAGAZINE;
    public static final MagazineItem BOLT_S24_MAGAZINE;
    public static final MagazineItem PULSE_S20_MAGAZINE;

    public static void register() {
        ArrayList<String> sortedItems = new ArrayList<>(MAGAZINES.keySet());
        sortedItems.sort(Comparator.naturalOrder());

        for (String item : sortedItems) {
            Registry.register(Registry.ITEM, Utils.ID(item), MAGAZINES.get(item));
        }
    }

    static {

        FabricItemSettings defaultMagazineSettings = new FabricItemSettings().group(GunItemGroups.GUNS).maxCount(1);

        /*
        C8MM_S6_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_8, 6);
        MAGAZINES.put("c8mm_s6_magazine", C8MM_S6_MAGAZINE);

        C8MM_S8_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_8, 8);
        MAGAZINES.put("c8mm_s8_magazine", C8MM_S8_MAGAZINE);

        C8MM_S12_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_8, 12);
        MAGAZINES.put("c8mm_s12_magazine", C8MM_S12_MAGAZINE);

        C12MM_S8_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_12, 8);
        MAGAZINES.put("c12mm_s8_magazine", C12MM_S8_MAGAZINE);

        C12MM_S12_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_12, 12);
        MAGAZINES.put("c12mm_s12_magazine", C12MM_S12_MAGAZINE);

        G12_S8_BOX_MAGAZINE = new BoxMagazineItem(defaultMagazineSettings, Caliber.GAU_12, 8);
        MAGAZINES.put("g12_s8_box_magazine", G12_S8_BOX_MAGAZINE);

        G12_S20_DRUM_MAGAZINE = new DrumMagazineItem(defaultMagazineSettings, Caliber.GAU_12, 20);
        MAGAZINES.put("g12_s20_drum_magazine", G12_S20_DRUM_MAGAZINE);
         */

        C9MM_S20_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_9, 20);
        MAGAZINES.put("c9mm_s20_magazine", C9MM_S20_MAGAZINE);

        BOLT_S12_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_19, 12);
        MAGAZINES.put("bolt_s12_magazine", BOLT_S12_MAGAZINE);

        BOLT_S24_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.CAL_19, 24);
        MAGAZINES.put("bolt_s24_magazine", BOLT_S24_MAGAZINE);

        PULSE_S20_MAGAZINE = new MagazineItem(defaultMagazineSettings, Caliber.PULSE, 20);
        MAGAZINES.put("pulse_s20_magazine", PULSE_S20_MAGAZINE);

    }

}
