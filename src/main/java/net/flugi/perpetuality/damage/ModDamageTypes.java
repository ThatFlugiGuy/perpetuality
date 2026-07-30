package net.flugi.perpetuality.damage;

import net.fabricmc.api.ModInitializer;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes implements ModInitializer {
    public static final RegistryKey<DamageType> UNCANNY_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(Perpetuality.MOD_ID, "uncanny"));


    @Override
    public void onInitialize() {

    }
}
