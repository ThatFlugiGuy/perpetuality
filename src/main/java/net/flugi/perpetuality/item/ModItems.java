package net.flugi.perpetuality.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.block.ModBlocks;
//import net.flugi.perpetuality.component.ModDataComponentTypes;
import net.flugi.perpetuality.item.custom.BlindingStewItem;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static net.flugi.perpetuality.item.ModFoodComponents.BLINDING_FOOD_COMPONENT;
import static net.flugi.perpetuality.item.ModFoodComponents.BLINDING_FOOD_CONSUMABLE_COMPONENT;

public class ModItems {



    public static final Item BLINDING_STEW = register("blinding_stew", BlindingStewItem::new, new Item.Settings()
            .food(BLINDING_FOOD_COMPONENT, BLINDING_FOOD_CONSUMABLE_COMPONENT)
            .maxCount(32)
            .useRemainder(Items.BOWL)
    );

    public static final Item DUBIOUS_STEW = register("dubious_stew", Item::new, new Item.Settings());

    public static final Item GENERIC_STEW = register("generic_stew", Item::new, new Item.Settings()
            .maxCount(16)
            .useRemainder(Items.BOWL)
    );
    /*
    public static final Item LANTERN = register("lantern", LanternItem::new, new Item.Settings()
            .component(ModDataComponentTypes.LANTERN_COOLDOWN, false)
            .component(ModDataComponentTypes.LANTERN_CHARGE, 900)
            .component(ModDataComponentTypes.LANTERN_STATE, false)
            .maxCount(1)
    );*/


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
            .icon(()-> new ItemStack(ModItems.BLINDING_STEW))
            .displayName(Text.translatable("itemGroup.perpetuality"))
            .entries((((displayContext, entries) -> {
                entries.add(ModItems.BLINDING_STEW);
                entries.add(ModItems.DUBIOUS_STEW);
                //entries.add(ModItems.LANTERN);
                entries.add(ModBlocks.BLOCK_PARADIGM.asItem());
            })))
            .build();





    public static  void  initialize() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.BLINDING_STEW);
                    itemGroup.add(ModItems.DUBIOUS_STEW);
                });

        Registry.register(Registries.ITEM_GROUP, PERPETUALITY_CREATIVE_TAB_KEY, PERPETUALITY_CREATIVE_TAB);

        Perpetuality.LOGGER.info("rejestering items for perpetuahlity");
    }


}

