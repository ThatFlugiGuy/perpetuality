package net.flugi.perpetuality.datagen;


import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.flugi.perpetuality.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PERPETUAL_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEAT_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGETABLE_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.BORSCHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREAD_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.APPLE_COMPOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORUS_COMPOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCOA_CEREAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRUIT_COMPOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRUIT_PORRIDGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_BERRY_COMPOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KELP_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.MASHED_POTATOES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PORRIDGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEET_BERRY_COMPOTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRT_STEW,Models.GENERATED);
    }

    @Override
    public String getName() {
        return "ModModelProvider";
    }
}

