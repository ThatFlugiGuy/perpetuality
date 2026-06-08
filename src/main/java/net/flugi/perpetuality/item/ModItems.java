package net.flugi.perpetuality.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLINDING_STEW = registerItem("blinding_stew",new Item(new Item.Settings()));
    public static final Item DUBIOUS_STEW = registerItem("dubious_stew",new Item(new Item.Settings()));


   private static Item registerItem(String name, Item item) {
       return Registry.register(Registries.ITEM, Identifier.of(Perpetuality.MOD_ID, name), item);
   }


    public static void registerModItems(){
        Perpetuality.LOGGER.info("Registering new soup...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(BLINDING_STEW);
            fabricItemGroupEntries.add(DUBIOUS_STEW);
        });
    }


}
