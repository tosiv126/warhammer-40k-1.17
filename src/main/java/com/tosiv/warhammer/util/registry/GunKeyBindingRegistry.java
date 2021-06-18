package com.tosiv.warhammer.util.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public final class GunKeyBindingRegistry {

    public static final KeyBinding RELOAD_KEY = new KeyBinding("key.warhammer.reload", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_R, "category.warhammer.warhammer");

    public static void register() {
        KeyBindingHelper.registerKeyBinding(RELOAD_KEY);
    }

}
