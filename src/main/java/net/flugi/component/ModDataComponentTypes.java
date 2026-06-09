package net.flugi.component;

import com.mojang.serialization.Codec;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<Boolean> LANTERN_STATE = register("lantern_state", builder -> builder.codec(Codec.BOOL));
    public static final ComponentType<Integer> LANTERN_CHARGE = register("lantern_charge",integerBuilder -> integerBuilder.codec(Codec.INT));
    private  static  <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Perpetuality.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Perpetuality.LOGGER.info("Registering components for good tasting stew");
    }


}
