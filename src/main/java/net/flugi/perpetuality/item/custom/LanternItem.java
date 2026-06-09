package net.flugi.perpetuality.item.custom;

import net.flugi.component.ModDataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.math.Fraction;

public class LanternItem extends Item {
    public LanternItem(Settings settings) {
        super(settings);
    }

    private static final int MAX_CHARGE = 400;
    private static final int ITEM_BAR_COLOR = MathHelper.packRgb(0.77F, 0.53F, 0.88F);
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.swingHand(hand);
        if (!world.isClient) {
            if (user.getStackInHand(hand).get(ModDataComponentTypes.LANTERN_STATE)) {
                user.getStackInHand(hand).set(ModDataComponentTypes.LANTERN_STATE, false);
                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS);
            }
            else if (!user.getStackInHand(hand).get(ModDataComponentTypes.LANTERN_STATE)) {
                user.getStackInHand(hand).set(ModDataComponentTypes.LANTERN_STATE, true);
                world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS);
            }
            //Perpetuality.LOGGER.info(String.valueOf(user.getStackInHand(hand)));
            //Perpetuality.LOGGER.info(String.valueOf(user.getStackInHand(hand).get(ModDataComponentTypes.LANTERN_STATE)));
        }
        return super.use(world, user, hand);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (stack.get(ModDataComponentTypes.LANTERN_CHARGE) == null) {
            stack.set(ModDataComponentTypes.LANTERN_CHARGE,0);
        }
        if (stack.get(ModDataComponentTypes.LANTERN_STATE) == null) {
            stack.set(ModDataComponentTypes.LANTERN_STATE,false);
        }

        if (!world.isClient()) {
            int currentCharge = stack.get(ModDataComponentTypes.LANTERN_CHARGE);

            if (stack.get(ModDataComponentTypes.LANTERN_STATE) && currentCharge >0) {
                stack.set(ModDataComponentTypes.LANTERN_CHARGE,currentCharge-3);
            } else if (!stack.get(ModDataComponentTypes.LANTERN_STATE) && currentCharge < MAX_CHARGE) {
                stack.set(ModDataComponentTypes.LANTERN_CHARGE,currentCharge+1);
            } else if (currentCharge <= 0) {
                stack.set(ModDataComponentTypes.LANTERN_STATE, false);
                world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS);
                world.playSound(null, entity.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS);
            }

           // Perpetuality.LOGGER.info(String.valueOf(stack.get(ModDataComponentTypes.LANTERN_CHARGE)));
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        int currentCharge;
        if (stack.get(ModDataComponentTypes.LANTERN_CHARGE) == null) {
            currentCharge = MAX_CHARGE;
        }
        else {
            currentCharge = stack.get(ModDataComponentTypes.LANTERN_CHARGE);
        }
        return currentCharge< MAX_CHARGE;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        int currentCharge;
        if (stack.get(ModDataComponentTypes.LANTERN_CHARGE) == null) {
            currentCharge = MAX_CHARGE;
        }
        else {
            currentCharge = stack.get(ModDataComponentTypes.LANTERN_CHARGE);
        }
        return MathHelper.multiplyFraction(Fraction.getFraction((double) currentCharge / MAX_CHARGE), 12);
    }

    @Override
    public int getItemBarColor(ItemStack stack) { return ITEM_BAR_COLOR; }

    @Override
    public boolean allowComponentsUpdateAnimation(PlayerEntity player, Hand hand, ItemStack oldStack, ItemStack newStack) {
        return false;
    }
}
