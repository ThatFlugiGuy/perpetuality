package net.flugi.perpetuality;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.client.particle.BoilingWaterParticle;
import net.flugi.perpetuality.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class PerpetualityClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {


        ColorProviderRegistry.BLOCK.register(
                (state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getWaterColor(world, pos) : -1,
                ModBlocks.CROCKPOT_BLOCK);

        BlockRenderLayerMap.putBlock(ModBlocks.CROCKPOT_BLOCK, BlockRenderLayer.TRANSLUCENT);
        ParticleFactoryRegistry.getInstance().register(Perpetuality.BOIL_PARTICLE, BoilingWaterParticle.Factory::new);

        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.getItem()== ModItems.CROCKPOT) {
                list.add(Text.translatable("itemToolTip.perpetuality.crockpot_item").formatted(Formatting.GRAY));
            }
        }));




        Perpetuality.interiority = () -> MinecraftClient.getInstance().player;
    }



    public static ClientWorld world() {
        return MinecraftClient.getInstance().world;
    }



    public static ClientPlayerEntity player() {
        return MinecraftClient.getInstance().player;
    }




}
