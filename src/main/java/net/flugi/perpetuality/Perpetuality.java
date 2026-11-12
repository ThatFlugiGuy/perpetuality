package net.flugi.perpetuality;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.block.entity.ModBlockEntities;
import net.flugi.perpetuality.item.ModFoodComponents;
import net.flugi.perpetuality.item.ModItems;
import net.flugi.perpetuality.recipe.ModRecipes;
import net.flugi.perpetuality.sounds.ModSounds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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


	public static final SimpleParticleType BOIL_PARTICLE = FabricParticleTypes.simple();


	@Override
	public void onInitialize() {

		PerpetualityConfig.load();


		if (PerpetualityConfig.INSTANCE.vanilla_stew_rebalance) {
			opStewRebalance(Items.MUSHROOM_STEW, 16, ModFoodComponents.MUSHROOM_STEW);
			opStewRebalance(Items.RABBIT_STEW, 16, FoodComponents.RABBIT_STEW);
			opStewRebalance(Items.BEETROOT_SOUP, 16, ModFoodComponents.BEETROOT_SOUP);
		}


		ModItems.initialize();
		ModBlocks.initialize();
		ModRecipes.initialize();
		ModBlockEntities.initialize();
		ModSounds.init();


		Registry.register(Registries.PARTICLE_TYPE, Perpetuality.id("boil_particle"), BOIL_PARTICLE);

		LOGGER.info("evil soup evil soup evil soup evil soup evil soup evil soup");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	public static void opStewRebalance(Item item, int count, FoodComponent foodComponent) {
		DefaultItemComponentEvents.MODIFY.register(context -> {
			context.modify(item, builder -> {
				int maxCount = item.getMaxCount();
				builder.add(DataComponentTypes.MAX_STACK_SIZE, Math.max(maxCount, count))
						.add(DataComponentTypes.FOOD, foodComponent);
			});
		});
	}

}

