package net.flugi.perpetuality.bulshittt;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.flugi.perpetuality.bulshittt.net.S2CAnsibleQuale;

public class ModNetworking {
    public static void init() {


        PayloadTypeRegistry.playS2C().register(
                S2CAnsibleQuale.ID,
                S2CAnsibleQuale.CODEC
        );

    }
}
