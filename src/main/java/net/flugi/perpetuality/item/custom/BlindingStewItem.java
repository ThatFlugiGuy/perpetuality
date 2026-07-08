package net.flugi.perpetuality.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BlindingStewItem extends Item {

    public BlindingStewItem(Settings settings) { super(settings); }


    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if (!world.isClient()) {

            if (user.isInCreativeMode()) {
                user.kill((ServerWorld) world);
            }
        }


        return super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
}
