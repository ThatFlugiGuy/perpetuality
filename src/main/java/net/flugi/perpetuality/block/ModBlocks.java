package net.flugi.perpetuality.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.flugi.perpetuality.Perpetuality;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block VEILED_TEST_BLOCK = registerBlock("veiled_test_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(0.1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .allowsSpawning(null)));

    public static final Block VEIL = registerBlock("veil",
            new Block(AbstractBlock.Settings.create()
                    .strength(255).resistance(255).hardness(255)
                    .noCollision()
                    .air()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Perpetuality.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Perpetuality.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Perpetuality.LOGGER.info("registring lbocks and stuff idk");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(fabricItemGroupEntries -> {

            fabricItemGroupEntries.add(ModBlocks.VEILED_TEST_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.VEIL);

        });
    }
}
