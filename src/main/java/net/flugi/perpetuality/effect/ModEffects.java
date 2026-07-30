package net.flugi.perpetuality.effect;

import net.flugi.perpetuality.Perpetuality;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


public class ModEffects{

    public static final RegistryEntry<StatusEffect> TRUE_BLINDNESS =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Perpetuality.MOD_ID, "true_blindness"), new TrueBlindnessEffect());


    public static void initialize() {

    }
}