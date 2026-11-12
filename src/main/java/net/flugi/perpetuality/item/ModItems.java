package net.flugi.perpetuality.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.item.custom.CrockPotItem;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {



    /*public static final Item BLINDING_STEW = register("blinding_stew", BlindingStewItem::new, new Item.Settings()
            .food(BLINDING_FOOD_COMPONENT, BLINDING_FOOD_CONSUMABLE_COMPONENT)
            .maxCount(32)
            .useRemainder(Items.BOWL)
    );*/

    //public static final Item DUBIOUS_STEW = register("dubious_stew", Item::new, new Item.Settings());

    // stews type shit
    public static final Item PERPETUAL_STEW = register("perpetual_stew", Item::new, new
            Item.Settings().food(ModFoodComponents.PERPETUAL_STEW).maxCount(16).useRemainder(Items.BOWL));
    public static final Item MEAT_STEW = register("meat_stew", Item::new, new
            Item.Settings().food(ModFoodComponents.MEAT_STEW).maxCount(16).useRemainder(Items.BOWL));
    public static final Item VEGETABLE_STEW = register("vegetable_stew", Item::new, new
            Item.Settings().food(ModFoodComponents.VEGETABLE_STEW).maxCount(16).useRemainder(Items.BOWL));
    public static final Item KELP_STEW = register("kelp_stew", Item::new, new
            Item.Settings().food(ModFoodComponents.KELP_STEW).maxCount(16).useRemainder(Items.BOWL));
    public static final Item DIRT_STEW = register("dirt_stew", Item::new, new
            Item.Settings().food(ModFoodComponents.DIRT_STEW).maxCount(16).useRemainder(Items.BOWL));
    public static final Item BORSCHT = register("borscht", Item::new, new
            Item.Settings().food(ModFoodComponents.BORSCHT).maxCount(16).useRemainder(Items.BOWL));
    public static final Item PORRIDGE = register("porridge", Item::new, new
            Item.Settings().food(ModFoodComponents.PORRIDGE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item FRUIT_PORRIDGE = register("fruit_porridge", Item::new, new
            Item.Settings().food(ModFoodComponents.FRUIT_PORRIDGE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item MASHED_POTATOES = register("mashed_potatoes", Item::new, new
            Item.Settings().food(ModFoodComponents.MASHED_POTATOES).maxCount(16).useRemainder(Items.BOWL));
    public static final Item COCOA_CEREAL = register("cocoa_cereal", Item::new, new
            Item.Settings().food(ModFoodComponents.COCOA_CEREAL).maxCount(16).useRemainder(Items.BOWL));
    public static final Item BREAD_SOUP = register("bread_soup", Item::new, new
            Item.Settings().food(ModFoodComponents.BREAD_SOUP).maxCount(16).useRemainder(Items.BOWL));
    public static final Item APPLE_COMPOTE = register("apple_compote", Item::new, new
            Item.Settings().food(ModFoodComponents.APPLE_COMPOTE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item CHORUS_COMPOTE = register("chorus_compote", Item::new, new
            Item.Settings().food(ModFoodComponents.CHORUS_COMPOTE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item GLOW_BERRY_COMPOTE = register("glow_berry_compote", Item::new, new
            Item.Settings().food(ModFoodComponents.GLOW_BERRY_COMPOTE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item SWEET_BERRY_COMPOTE = register("sweet_berry_compote", Item::new, new
            Item.Settings().food(ModFoodComponents.SWEET_BERRY_COMPOTE).maxCount(16).useRemainder(Items.BOWL));
    public static final Item FRUIT_COMPOTE = register("fruit_compote", Item::new, new
            Item.Settings().food(ModFoodComponents.FRUIT_COMPOTE).maxCount(16).useRemainder(Items.BOWL));



    public static final  Item CROCKPOT = register("crockpot", CrockPotItem::new, new Item.Settings()

    );



    public  static <T extends Item> T register(String name, Function<Item.Settings, T> itemFactory, Item.Settings settings) {

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, name));

        T item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final RegistryKey<ItemGroup> PERPETUALITY_CREATIVE_TAB_KEY = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(), Identifier.of(Perpetuality.MOD_ID, "perpetuality_items")
    );
    public static final ItemGroup PERPETUALITY_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(()-> new ItemStack(ModItems.PERPETUAL_STEW))
            .displayName(Text.translatable("itemGroup.perpetuality"))
            .entries((((displayContext, entries) -> {
                //entries.add(ModItems.BLINDING_STEW);
                //entries.add(ModItems.DUBIOUS_STEW);
                entries.add(ModItems.CROCKPOT);
                entries.add(Items.CAMPFIRE);
                entries.add(ModItems.PERPETUAL_STEW);
                entries.add(ModItems.VEGETABLE_STEW);
                entries.add(ModItems.MEAT_STEW);
                entries.add(ModItems.KELP_STEW);
                entries.add(ModItems.BORSCHT);
                entries.add(ModItems.MASHED_POTATOES);
                entries.add(ModItems.FRUIT_COMPOTE);
                entries.add(ModItems.APPLE_COMPOTE);
                entries.add(ModItems.SWEET_BERRY_COMPOTE);
                entries.add(ModItems.GLOW_BERRY_COMPOTE);
                entries.add(ModItems.CHORUS_COMPOTE);
                entries.add(ModItems.PORRIDGE);
                entries.add(ModItems.FRUIT_PORRIDGE);
                entries.add(ModItems.COCOA_CEREAL);
                entries.add(ModItems.DIRT_STEW);
                entries.add(ModItems.BREAD_SOUP);
                //entries.add(ModItems.LANTERN);
                entries.add(ModBlocks.BLOCK_PARADIGM.asItem());
            })))
            .build();





    public static  void  initialize() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.PERPETUAL_STEW);
                    itemGroup.add(ModItems.VEGETABLE_STEW);
                    itemGroup.add(ModItems.MEAT_STEW);
                    itemGroup.add(ModItems.KELP_STEW);
                    itemGroup.add(ModItems.BORSCHT);
                    itemGroup.add(ModItems.MASHED_POTATOES);
                    itemGroup.add(ModItems.FRUIT_COMPOTE);
                    itemGroup.add(ModItems.APPLE_COMPOTE);
                    itemGroup.add(ModItems.SWEET_BERRY_COMPOTE);
                    itemGroup.add(ModItems.GLOW_BERRY_COMPOTE);
                    itemGroup.add(ModItems.CHORUS_COMPOTE);
                    itemGroup.add(ModItems.PORRIDGE);
                    itemGroup.add(ModItems.FRUIT_PORRIDGE);
                    itemGroup.add(ModItems.COCOA_CEREAL);
                    itemGroup.add(ModItems.DIRT_STEW);
                    itemGroup.add(ModItems.BREAD_SOUP);
                });

        Registry.register(Registries.ITEM_GROUP, PERPETUALITY_CREATIVE_TAB_KEY, PERPETUALITY_CREATIVE_TAB);

        Perpetuality.LOGGER.info("rejestering items for perpetuahlity");
    }


}

