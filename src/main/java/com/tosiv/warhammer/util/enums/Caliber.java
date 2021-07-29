package com.tosiv.warhammer.util.enums;

public enum Caliber {

    CAL_4("4mm"),
    CAL_6("6mm"),
    CAL_8("8mm"),
    CAL_9("9mm"),
    CAL_10("10mm"),
    CAL_12("12mm"),
    GAU_12("12 gauge"),
    PULSE("pulse"),
    CAL_19("19mm");

    private final String name;

    Caliber(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
