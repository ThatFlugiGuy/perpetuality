package net.flugi.perpetuality.bulshittt.view;

import net.flugi.perpetuality.bulshittt.ModEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Unit;
import net.minecraft.world.World;

/*
public class AntimonicView extends AbstractView<View.Context<World, PlayerEntity>> {

    @Override
    public void open(World world, PlayerEntity user) {
        if (world.isClient()) callback().accept(View.Context.of(world, user));
        else if (active(user)) {
            reset(user);
        } else {
            user.setAttached(ModEntities.CONTRADICTORY, Unit.INSTANCE);
        }
    }

    public static boolean active(PlayerEntity user) {
        return !user.getEntityWorld().isClient() && user.hasAttached(ModEntities.CONTRADICTORY);
    }

    @Override
    public void reset(PlayerEntity user) {
        user.removeAttached(ModEntities.CONTRADICTORY);
    }

}*/
