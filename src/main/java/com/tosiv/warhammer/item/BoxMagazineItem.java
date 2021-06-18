package com.tosiv.warhammer.item;

import com.tosiv.warhammer.util.enums.Caliber;

public class BoxMagazineItem extends MagazineItem {

    public BoxMagazineItem(Settings settings, Caliber caliber, int capacity) {
        super(settings, caliber, capacity);
    }

    @Override
    public String getTranslationKey() {
        return "item.customizable_guns.box_magazine";
    }

}
