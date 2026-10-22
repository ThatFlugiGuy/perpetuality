package net.flugi.perpetuality;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.block.custom.VeiledBlock;
//import net.flugi.perpetuality.bulshittt.client.gfx.AntimonicConsistencyProperty;
//import net.flugi.perpetuality.bulshittt.client.view.CAntimonicView;
//import net.flugi.perpetuality.bulshittt.net.S2CAnsibleQuale;
//import net.flugi.perpetuality.bulshittt.state.Necessity;
//import net.flugi.perpetuality.bulshittt.state.Sachverhalten;
//import net.flugi.perpetuality.bulshittt.view.Views;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.item.property.bool.BooleanProperties;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.chunk.ChunkSection;

public class PerpetualityClient implements ClientModInitializer {



    @Override
    public void onInitializeClient() {


        BlockRenderLayerMap.putBlock(ModBlocks.POT_BLOCK, BlockRenderLayer.TRANSLUCENT);


        Perpetuality.interiority = () -> MinecraftClient.getInstance().player;
    }



    public static ClientWorld world() {
        return MinecraftClient.getInstance().world;
    }



    public static ClientPlayerEntity player() {
        return MinecraftClient.getInstance().player;
    }




}
