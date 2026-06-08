package net.flugi.perpetuality.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PERPETUALITY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Perpetuality.MOD_ID, "perpetuality_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BLINDING_STEW))
                    .displayName(Text.translatable("itemgroup.perpetuality.perpetuality_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLINDING_STEW);
                        entries.add(ModItems.DUBIOUS_STEW);

                    }).build());

    public static void registerItemGroups() {
        Perpetuality.LOGGER.info("yada yada registering stuff yet again");
    }

}
