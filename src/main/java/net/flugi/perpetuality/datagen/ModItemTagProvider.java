package net.flugi.perpetuality.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> STEW_INGREDIENTS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "stew_ingredients"));
    public static final TagKey<Item> MEATS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID,"meats"));
    public static final TagKey<Item> VEGETABLES = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "vegetables"));
    public static final TagKey<Item> FRUITS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "fruits"));
    public static final TagKey<Item> MUSHROOMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "mushrooms"));

    //tag with dirt in it
    public static final TagKey<Item> TAGLASSO = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "taglasso"));

    //stew ruiner ingredients
    public static final TagKey<Item> AWHELLNAWDONTPUTTHISINYOURSTEW = TagKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, "awhellnawdontputthisinyourstew"));

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(MEATS)
                .add(Items.BEEF)
                .add(Items.COOKED_BEEF)
                .add(Items.PORKCHOP)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.MUTTON)
                .add(Items.COOKED_MUTTON)
                .add(Items.CHICKEN)
                .add(Items.COOKED_CHICKEN)
                .add(Items.RABBIT)
                .add(Items.COOKED_RABBIT)
                .setReplace(true);

        valueLookupBuilder(VEGETABLES)
                .add(Items.CARROT)
                .add(Items.BEETROOT)
                .add(Items.POTATO)
                .add(Items.BAKED_POTATO)
                .setReplace(true);

        valueLookupBuilder(TAGLASSO)
                .add(Items.DIRT)
                .add(Items.GRASS_BLOCK)
                .add(Items.PODZOL)
                .add(Items.MYCELIUM)
                .add(Items.COARSE_DIRT)
                .add(Items.MUD)
                .add(Items.DIRT_PATH)
                .add(Items.MUDDY_MANGROVE_ROOTS)
                .add(Items.ROOTED_DIRT)
                .add(Items.FARMLAND)
                .setReplace(true);

        valueLookupBuilder(MUSHROOMS)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.RED_MUSHROOM)
                .setReplace(true);

        valueLookupBuilder(FRUITS)
                .add(Items.APPLE)
                .add(Items.CHORUS_FRUIT)
                .add(Items.GLOW_BERRIES)
                .add(Items.SWEET_BERRIES)
                .setReplace(true);

        // this one just the stuff that you can put in stew or not
        valueLookupBuilder(STEW_INGREDIENTS)
                .addTag(MEATS)
                .addTag(MUSHROOMS)
                .addTag(VEGETABLES)
                .addTag(TAGLASSO)
                .addTag(FRUITS)
                .add(Items.DRIED_KELP)
                .add(Items.BREAD)
                .add(Items.WHEAT)
                .add(Items.COCOA_BEANS)
                .add(Items.MILK_BUCKET)
                .setReplace(true);
    }
}
