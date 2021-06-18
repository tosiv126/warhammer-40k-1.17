package com.tosiv.warhammer.item;

import com.tosiv.warhammer.util.enums.Caliber;

public class DrumMagazineItem extends MagazineItem {

    public DrumMagazineItem(Settings settings, Caliber caliber, int capacity) {
        super(settings, caliber, capacity);
    }

    @Override
    public String getTranslationKey() {
        return "item.customizable_guns.drum_magazine";
    }

}
