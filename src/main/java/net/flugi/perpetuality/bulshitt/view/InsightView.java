package net.flugi.perpetuality.bulshitt.view;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Unit;
import net.minecraft.world.World;
import net.flugi.perpetuality.entity.ModEntities;

public class InsightView extends AbstractView<View.Context<World, PlayerEntity>> {

    @Override
    public void open(World world, PlayerEntity user) {
        if (world.isClient()) callback().accept(View.Context.of(world, user));
        else if (active(user)) {
            reset(user);
        } else {
            user.setAttached(ModEntities.INSIGHT, Unit.INSTANCE);
        }
    }

    public static boolean active(PlayerEntity user) {
        return !user.getEntityWorld().isClient() && user.hasAttached(ModEntities.INSIGHT);
    }

    @Override
    public void reset(PlayerEntity user) {
        user.removeAttached(ModEntities.INSIGHT);
    }




}
