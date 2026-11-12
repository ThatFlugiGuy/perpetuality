package net.flugi.perpetuality.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.block.custom.PotBlock;
import net.flugi.perpetuality.block.custom.VeiledBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModBlocks {


    //:: NOT YET :://
    public static final Block BLOCK_PARADIGM = register(
            "block_paradigm",
            VeiledBlock.of(true),
            AbstractBlock.Settings.create()
                    //.suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .strength(0.5f)
                    , true
    );
    //:: YOU'LL HAVE TO WAIT AND SEE :://



    //loot table of pot not really working ):
    // neither does it have the block breaking overlay
    public static final Block CROCKPOT_BLOCK = register("crockpot_block", PotBlock::new, AbstractBlock.Settings.create()
            .sounds(BlockSoundGroup.DECORATED_POT).strength(1f)
            .luminance(PotBlock::getLuminance)
            , false
    );



    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem ) {

        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Perpetuality.MOD_ID, name));
    }
    private  static  RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Perpetuality.MOD_ID, name));
    }

    public static void initialize() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.add(ModBlocks.BLOCK_PARADIGM.asItem());
                });

        Perpetuality.LOGGER.info("geristering blocks for perpetuah");
    }


}
