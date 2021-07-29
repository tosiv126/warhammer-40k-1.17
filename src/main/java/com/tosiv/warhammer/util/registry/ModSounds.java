package com.tosiv.warhammer.util.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    //Servitor Sounds
    public static final Identifier SERVITOR_AMBIENT = new Identifier("warhammer:servitor_one_ambient");
    public static SoundEvent SERVITOR_AMBIENT_EVENT = new SoundEvent(SERVITOR_AMBIENT);

    //Gun Sounds
    public static final Identifier RELOAD = new Identifier("warhammer:reload");
    public static SoundEvent RELOAD_EVENT = new SoundEvent(RELOAD);

    public static final Identifier BOLTER_PISTOL_SHOOT = new Identifier("warhammer:bolterpistolshoot");
    public static SoundEvent BOLTER_PISTOL_SHOOT_EVENT = new SoundEvent(BOLTER_PISTOL_SHOOT);

    public static final Identifier BOLTER_SHOOT = new Identifier("warhammer:boltershoot");
    public static SoundEvent BOLTER_SHOOT_EVENT = new SoundEvent(BOLTER_SHOOT);

    public static final Identifier C9MM_SHOOT = new Identifier("warhammer:9mmshoot");
    public static SoundEvent C9MM_SHOOT_EVENT = new SoundEvent(C9MM_SHOOT);

    public static final Identifier PULSE_CARBINE_SHOOT = new Identifier("warhammer:pulsecarbineshoot");
    public static SoundEvent PULSE_CARBINE_SHOOT_EVENT = new SoundEvent(PULSE_CARBINE_SHOOT);

    public static final Identifier C19MM_SHOOT = new Identifier("warhammer:19mmshoot");
    public static SoundEvent C19MM_SHOOT_EVENT = new SoundEvent(C19MM_SHOOT);

    public static final Identifier BOLT_HIT = new Identifier("warhammer:bolthit");
    public static SoundEvent BOLT_HIT_EVENT = new SoundEvent(BOLT_HIT);

    public static final Identifier BOLT_RELOAD = new Identifier("warhammer:boltreload");
    public static SoundEvent BOLT_RELOAD_EVENT = new SoundEvent(BOLT_RELOAD);

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, SERVITOR_AMBIENT, SERVITOR_AMBIENT_EVENT);
        Registry.register(Registry.SOUND_EVENT, RELOAD, RELOAD_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLTER_PISTOL_SHOOT, BOLTER_PISTOL_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLTER_SHOOT, BOLTER_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, C9MM_SHOOT, C9MM_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, C19MM_SHOOT, C19MM_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, PULSE_CARBINE_SHOOT, PULSE_CARBINE_SHOOT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLT_HIT, BOLT_HIT_EVENT);
        Registry.register(Registry.SOUND_EVENT, BOLT_RELOAD, BOLT_RELOAD_EVENT);
    }

}


