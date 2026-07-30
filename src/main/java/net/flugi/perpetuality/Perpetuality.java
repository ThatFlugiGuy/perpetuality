package net.flugi.perpetuality;

import net.fabricmc.api.ModInitializer;

import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.bulshittt.ModNetworking;
import net.flugi.perpetuality.component.ModDataComponentTypes;
import net.flugi.perpetuality.effect.ModEffects;
import net.flugi.perpetuality.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Supplier;

public class Perpetuality implements ModInitializer {
	public static final String MOD_ID = "perpetuality";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static Supplier<PlayerEntity> interiority = () -> {
		throw new NotImplementedException("attempted external self reference");
	};

	public static PlayerEntity self() {
		return interiority.get();
	}

	public static <T extends CustomPayload> CustomPayload.Id<T> payloadId(String identififer) {
		return new CustomPayload.Id<>(id(identififer));
	}


	@Override
	public void onInitialize() {

		ModItems.initialize();
		ModBlocks.initialize();
		ModNetworking.init();
		ModEffects.initialize();

		ModDataComponentTypes.registerDataComponentTypes();

		LOGGER.info("evil soup evil soup evil soup evil soup evil soup evil soup");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

