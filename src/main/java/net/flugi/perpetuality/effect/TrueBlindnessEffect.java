package net.flugi.perpetuality.effect;

import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.bulshittt.ModEntities;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Unit;

public class TrueBlindnessEffect extends StatusEffect {
    protected TrueBlindnessEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x000000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {

        //Perpetuality.LOGGER.info(String.valueOf(duration));

        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        if (entity instanceof PlayerEntity) {
            Perpetuality.LOGGER.info(String.valueOf(entity.hasAttached(ModEntities.CONTRADICTORY)));
            if (! entity.hasAttached(ModEntities.CONTRADICTORY)) {

                entity.setAttached(ModEntities.CONTRADICTORY, Unit.INSTANCE);

                if (entity.getEntityWorld().isClient()) {
                    MinecraftClient client = MinecraftClient.getInstance();
                    client.worldRenderer.reload();
                }
            }
        }


        return super.applyUpdateEffect(world, entity, amplifier);
    }


    @Override
    public void onApplied(LivingEntity entity, int amplifier) {


        super.onApplied(entity, amplifier);
    }


    @Override
    public void onEffectRemoved(StatusEffectInstance effectInstance, LivingEntity entity) {

        if (entity instanceof PlayerEntity) {
            entity.removeAttached(ModEntities.CONTRADICTORY);
            if (entity.getEntityWorld().isClient()) {
                MinecraftClient client = MinecraftClient.getInstance();
                client.worldRenderer.reload();
            }
        }

        super.onEffectRemoved(effectInstance, entity);
    }
}
