package net.flugi.perpetuality.bulshittt.view;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import org.jetbrains.annotations.Nullable;
import net.flugi.perpetuality.Perpetuality;

import java.util.List;
import java.util.function.Predicate;

public class Views {
    private static final BiMap<Identifier, View> entries = HashBiMap.create();
    public static final Codecs.IdMapper<Identifier, ? extends View> MAPPER = new Codecs.IdMapper<>();
    public static final Codec<View> CODEC = Identifier.CODEC.flatXmap(
            id -> DataResult.success(entries.get(id)),
            view -> DataResult.success(entries.inverse().get(view))
    );
    public static final PacketCodec<ByteBuf, View> PACKET_CODEC = Identifier.PACKET_CODEC.xmap(entries::get, entries.inverse()::get);

    public static AntimonicView ANTIMONY = register("antimony", new AntimonicView());

    private static <T extends View> T register(String id, T v) {
        entries.put(Perpetuality.id(id), v);
        return v;
    }

    @Nullable
    public static View get(Identifier id) {
        return entries.get(id);
    }

    @Nullable
    public static Identifier getId(View v) {
        return entries.inverse().get(v);
    }

    // server observer
    public static boolean immaterial(PlayerEntity player) {
        return AntimonicView.active(player);
    }

    public static List<View> all() {
        return entries.values().stream().toList();
    }



}

