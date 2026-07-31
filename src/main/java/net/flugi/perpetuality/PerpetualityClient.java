package net.flugi.perpetuality;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.block.custom.VeiledBlock;
//import net.flugi.perpetuality.bulshittt.client.gfx.AntimonicConsistencyProperty;
import net.flugi.perpetuality.bulshittt.client.view.CAntimonicView;
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

public class PerpetualityClient implements ClientModInitializer {



    //public static final Sachverhalten AFFAIRS = new Sachverhalten();


    @Override
    public void onInitializeClient() {

        //Views.ANTIMONY.setCallback(c -> c.ap(CAntimonicView::open));

        Perpetuality.interiority = () -> MinecraftClient.getInstance().player;
        /*
        BooleanProperties.ID_MAPPER.put(
                Perpetuality.id("antimonic_consistency"),
                AntimonicConsistencyProperty.CODEC
        );*/
        /*
        ClientPlayNetworking.registerGlobalReceiver(
                S2CAnsibleQuale.ID,
                (payload, context) -> {
                    ClientWorld world = world();
                    PlayerEntity subject = player();
                    if (world != null && subject != null) {
                        payload.view().open(world, subject);
                    }
                }
        );*/


        VeiledBlock.solid = CAntimonicView::solidifyParadox;
        BlockRenderLayerMap.putBlock(ModBlocks.BLOCK_PARADIGM, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.BLOCK_EVILPARADIGM, BlockRenderLayer.CUTOUT);
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> CAntimonicView.setup());


    }



    public static ClientWorld world() {
        return MinecraftClient.getInstance().world;
    }
    /*
    public static void nextTick(Runnable r) {
        schedule(r, 1);
    }

    public static void schedule(Runnable r, int ticks) {
        synchronized (AFFAIRS) {
            AFFAIRS.enableFor(new Necessity(r), ticks);
        }
    }*/


    public static ClientPlayerEntity player() {
        return MinecraftClient.getInstance().player;
    }




}
