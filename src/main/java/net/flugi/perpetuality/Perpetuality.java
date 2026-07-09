package net.flugi.perpetuality;

import net.fabricmc.api.ModInitializer;

import net.flugi.perpetuality.component.ModDataComponentTypes;
import net.flugi.perpetuality.item.ModItems;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Perpetuality implements ModInitializer {
	public static final String MOD_ID = "perpetuality";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.initialize();

		ModDataComponentTypes.registerDataComponentTypes();

		LOGGER.info("evil soup evil soup evil soup evil soup evil soup evil soup");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}

