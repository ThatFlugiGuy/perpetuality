package net.flugi.perpetuality.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BlindingStewItem extends Item {
    public BlindingStewItem(Settings settings) { super(settings); }

    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        
        return super.isUsedOnRelease(stack);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isInCreativeMode()) {
            user.kill();
        }
        return super.use(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }
}
