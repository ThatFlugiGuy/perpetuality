package net.flugi.perpetuality.bulshitt.client;


import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.bulshitt.client.view.CInsightView;
import net.flugi.perpetuality.bulshitt.view.Views;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.property.bool.BooleanProperties;

public class PerpetualityClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        Views.INSIGHT.setCallback(c -> c.ap(CInsightView::open));

        ClientPlayNetworking.registerGlobalReceiver(
                S2CAnsibleQuale.ID,
                (payload, context) -> {
                    ClientWorld world = world();
                    PlayerEntity subject = player();
                    if (world != null && subject != null) {
                        payload.view().open(world, subject);
                    }
                }
        );



        //Perpetuality.interiority = () -> MinecraftClient.getInstance().player;

        BooleanProperties.ID_MAPPER.put(
                Perpetuality.id("antimonic_consistency"),
                AntimonicConsistencyProperty.CODEC
        );

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            CGroundingView.resetAll(false);
            Perspectives.reset();
        });

        ClientEntityEvents.ENTITY_LOAD.register(((entity, clientWorld) -> {
            if (entity instanceof ClientPlayerEntity)
                Perspectives.reset();
        }));

        ClientEntityEvents.ENTITY_UNLOAD.register((entity, clientWorld) -> {
            if (entity instanceof ClientPlayerEntity) {
                CGroundingView.resetAll(false);
            }
        });

        ParadoxBlock.solid = CAntimonicView::solidifyParadox;
        BlockRenderLayerMap.putBlock(OccBloccs.PARADOX, BlockRenderLayer.CUTOUT);
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> CAntimonicView.setup());

        ClientPlayNetworking.registerGlobalReceiver(
                S2CStabilizingPayload.ID, (s2CStabilizingPayload, context) -> CGroundingView.resetAll(true)
        );

    }

    public static void nextTick(Runnable r) {
        schedule(r, 1);
    }

    public static void schedule(Runnable r, int ticks) {
        synchronized (AFFAIRS) {
            AFFAIRS.enableFor(new Necessity(r), ticks);
        }
    }

    public static ClientWorld world() {
        return MinecraftClient.getInstance().world;
    }

    public static ClientPlayerEntity player() {
        return MinecraftClient.getInstance().player;
    }



}
