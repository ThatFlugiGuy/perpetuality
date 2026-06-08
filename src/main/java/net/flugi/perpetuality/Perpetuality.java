package net.flugi.perpetuality;

import net.fabricmc.api.ModInitializer;

import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.item.ModItemGroups;
import net.flugi.perpetuality.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Perpetuality implements ModInitializer {
	public static final String MOD_ID = "perpetuality";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		LOGGER.info("mmm soup");
	}
}