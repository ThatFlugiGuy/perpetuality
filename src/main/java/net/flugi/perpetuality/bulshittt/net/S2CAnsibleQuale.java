package net.flugi.perpetuality.bulshittt.net;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.flugi.perpetuality.Perpetuality;
//import net.flugi.perpetuality.bulshittt.view.View;
//import net.flugi.perpetuality.bulshittt.view.Views;

import java.util.function.Consumer;
/*
public record S2CAnsibleQuale(View view) implements CustomPayload {
    public static Id<S2CAnsibleQuale> ID = Perpetuality.payloadId("ansiblate_qualia");
    public static final PacketCodec<PacketByteBuf, S2CAnsibleQuale> CODEC =
            CustomPayload.codecOf(
                    (p, b) -> {
                        b.writeIdentifier(Views.getId(p.view));
                    },
                    (b) -> new S2CAnsibleQuale(Views.get(b.readIdentifier()))
            );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }

    private static Consumer<S2CAnsibleQuale> callback = null;

    public static void register(Consumer<S2CAnsibleQuale> sendPayloadCallback) {
        callback = sendPayloadCallback;
    }
}
*/