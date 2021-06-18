package com.tosiv.warhammer.util;

import com.tosiv.warhammer.Warhammer;
import net.minecraft.util.Identifier;

public class Utils {

    public static Identifier ID(String path) {
        return new Identifier(Warhammer.MOD_ID, path);
    }

}
