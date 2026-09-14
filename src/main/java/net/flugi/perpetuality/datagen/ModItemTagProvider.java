package net.flugi.perpetuality.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
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
                .setReplace(true);

        valueLookupBuilder(VEGETABLES)
                .add(Items.CARROT)
                .setReplace(true);

        valueLookupBuilder(TAGLASSO)
                .add(Items.DIRT)
                .setReplace(true);

        valueLookupBuilder(STEW_INGREDIENTS)
                .addTag(MEATS)
                .addTag(VEGETABLES)
                .addTag(TAGLASSO)
                .setReplace(true);
    }
}
