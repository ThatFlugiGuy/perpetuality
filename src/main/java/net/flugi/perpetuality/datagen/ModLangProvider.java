package net.flugi.perpetuality.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {

        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup  wrapperLookup, TranslationBuilder translationBuilder) {

        translationBuilder.add("item.perpetuality.crockpot","Crockpot");
        translationBuilder.add("item.perpetuality.perpetual_stew","Perpetual Stew");
        translationBuilder.add("item.perpetuality.meat_stew","Meat Stew");
        translationBuilder.add("item.perpetuality.vegetable_stew","Vegetable Stew");
        translationBuilder.add("item.perpetuality.kelp_stew","Kelp Stew");
        translationBuilder.add("item.perpetuality.dirt_stew","Dirt Stew");
        translationBuilder.add("item.perpetuality.borscht","Borscht");
        translationBuilder.add("item.perpetuality.porridge","Porridge");
        translationBuilder.add("item.perpetuality.fruit_porridge","Fruit Porridge");
        translationBuilder.add("item.perpetuality.mashed_potatoes","Mashed Potatoes");
        translationBuilder.add("item.perpetuality.cocoa_cereal","Cocoa Cereal");
        translationBuilder.add("item.perpetuality.bread_soup","Bread & Water Soup");
        translationBuilder.add("item.perpetuality.apple_compote","Apple Compote");
        translationBuilder.add("item.perpetuality.chorus_compote","Chorus Fruit Compote");
        translationBuilder.add("item.perpetuality.glow_berry_compote","Glow Berry Compote");
        translationBuilder.add("item.perpetuality.sweet_berry_compote","Sweet Berry Compote");
        translationBuilder.add("item.perpetuality.fruit_compote","Fruit Compote");

        translationBuilder.add("itemToolTip.perpetuality.crockpot_item","Place over a campfire to start cooking");

        translationBuilder.add("block.perpetuality.block_paradigm", "Paradigm");

        translationBuilder.add("itemGroup.perpetuality","Perpetuality");

        translationBuilder.add("sounds.perpetuality.water_boil","Water boils");
    }
}