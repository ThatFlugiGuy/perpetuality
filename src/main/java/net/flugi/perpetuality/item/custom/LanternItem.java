package net.flugi.perpetuality.item.custom;

import net.flugi.perpetuality.Perpetuality;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Objects;

public class LanternItem extends Item {
    public LanternItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            Perpetuality.LOGGER.info(String.valueOf(user.getStackInHand(hand)));
        }
        return super.use(world, user, hand);
    }


}
