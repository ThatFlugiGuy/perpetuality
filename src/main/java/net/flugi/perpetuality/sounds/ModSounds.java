package net.flugi.perpetuality.sounds;

import net.flugi.perpetuality.Perpetuality;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    private ModSounds() {}
    public static final SoundEvent WATER_BOIL = registerSound("water_boil");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Perpetuality.id(id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void init() {
        Perpetuality.LOGGER.info("registering sounds or something");
    }
}
