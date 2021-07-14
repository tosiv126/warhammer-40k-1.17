package com.tosiv.warhammer.util.registry.item;

import com.tosiv.warhammer.util.enums.Caliber;
import com.tosiv.warhammer.GunItemGroups;
import com.tosiv.warhammer.util.Utils;
import com.tosiv.warhammer.item.GunItem;
import com.tosiv.warhammer.util.registry.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class GunRegistry {

    private static final HashMap<String, Item> GUNS = new HashMap<>();

    public static final GunItem BOLT_PISTOL;
    public static final GunItem BOLTER;
    public static final GunItem AUTOPISTOL;
    /*
    public static final GunItem AA12;
    public static final GunItem RIFLE;
    public static final GunItem AWP;
     */

    public static void register() {
        ArrayList<String> sortedItems = new ArrayList<>(GUNS.keySet());
        sortedItems.sort(Comparator.naturalOrder());

        for (String item : sortedItems) {
            Registry.register(Registry.ITEM, Utils.ID(item), GUNS.get(item));
        }
    }

    static {

        FabricItemSettings defaultGunSettings = new FabricItemSettings().maxCount(1).group(GunItemGroups.GUNS);

        BOLT_PISTOL = new GunItem(defaultGunSettings, Caliber.CAL_19, 10, false, 5, 1, 0.8F, 1F);
        BOLT_PISTOL.addMagazineCapacity(12);
        BOLT_PISTOL.setSound(GunItem.SoundType.SHOOT, ModSounds.C19MM_SHOOT_EVENT);
        BOLT_PISTOL.setSound(GunItem.SoundType.RELOAD, ModSounds.BOLT_RELOAD_EVENT);
        GUNS.put("bolt_pistol", BOLT_PISTOL);

        BOLTER = new GunItem(defaultGunSettings, Caliber.CAL_19, 20, true, 5, 1, 0.8F, 1F);
        BOLTER.addMagazineCapacity(24);
        BOLTER.setSound(GunItem.SoundType.SHOOT, ModSounds.C19MM_SHOOT_EVENT);
        BOLTER.setSound(GunItem.SoundType.RELOAD, ModSounds.BOLT_RELOAD_EVENT);
        GUNS.put("bolter", BOLTER);

        AUTOPISTOL = new GunItem(defaultGunSettings, Caliber.CAL_9, 6, true, 2, 2, 0.8F, 1F);
        AUTOPISTOL.addMagazineCapacity(20);
        AUTOPISTOL.setSound(GunItem.SoundType.SHOOT, ModSounds.C9MM_SHOOT_EVENT);
        AUTOPISTOL.setSound(GunItem.SoundType.RELOAD, ModSounds.RELOAD_EVENT);
        GUNS.put("autopistol", AUTOPISTOL);

        /*
        RIFLE = new GunItem(defaultGunSettings, Caliber.CAL_12, 6, true, 6,2, 1F, 2.5F);
        RIFLE.addMagazineCapacity(12);
        GUNS.put("rifle", RIFLE);

        AWP = new GunItem(defaultGunSettings, Caliber.CAL_12, 20, false, 50,0, 2F, 10F);
        AWP.addMagazineCapacity(8);
        GUNS.put("awp", AWP);

        AA12 = new GunItem(defaultGunSettings, Caliber.GAU_12, 10, true, 16, 8, 0.75F, 4F);
        AA12.addMagazineCapacity(8);
        AA12.addMagazineCapacity(20);
        AA12.addMagazineCapacity(32);
        GUNS.put("aa12", AA12);
        */

    }

}
