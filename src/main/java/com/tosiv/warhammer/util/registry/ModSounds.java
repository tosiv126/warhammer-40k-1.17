package com.tosiv.warhammer.util.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    //Servitor Sounds
    public static final Identifier SERVITOR_AMBIENT = new Identifier("warhammer:servitor_one_ambient");
    public static SoundEvent SERVITOR_AMBIENT_EVENT = new SoundEvent(SERVITOR_AMBIENT);

    public static final Identifier BOLLTER_PISTOL_SHOOT = new Identifier("warhammer:bolterpistolshoot");
    public static SoundEvent BOLLTER_PISTOL_SHOOT_EVENT = new SoundEvent(BOLLTER_PISTOL_SHOOT);

    public static final Identifier BOLLTER_SHOOT = new Identifier("warhammer:boltershoot");
    public static SoundEvent BOLLTER_SHOOT_EVENT = new SoundEvent(BOLLTER_SHOOT);

    public static final Identifier BOLT_HIT = new Identifier("warhammer:bolthit");
    public static SoundEvent BOLT_HIT_EVENT = new SoundEvent(BOLT_HIT);

    public static final Identifier BOLT_RELOAD = new Identifier("warhammer:boltreload");
    public static SoundEvent BOLT_RELOAD_EVENT = new SoundEvent(BOLT_RELOAD);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, SERVITOR_AMBIENT, SERVITOR_AMBIENT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLLTER_PISTOL_SHOOT, BOLLTER_PISTOL_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLLTER_SHOOT, BOLLTER_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLT_HIT, BOLT_HIT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLT_RELOAD, BOLT_RELOAD_EVENT);
    }

}


