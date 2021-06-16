package com.tosiv.warhammer.util.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    //Servitor Sounds
    public static final Identifier SERVITOR_AMBIENT = new Identifier("warhammer:servitor_one_ambient");
    public static SoundEvent SERVITOR_AMBIENT_EVENT = new SoundEvent(SERVITOR_AMBIENT);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, ModSounds.SERVITOR_AMBIENT, SERVITOR_AMBIENT_EVENT);
    }
}


