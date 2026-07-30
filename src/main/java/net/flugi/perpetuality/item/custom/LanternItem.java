package net.flugi.perpetuality.item.custom;

import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.bulshittt.ModEntities;
import net.flugi.perpetuality.bulshittt.view.AntimonicView;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Unit;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.math.Fraction;
import org.jspecify.annotations.Nullable;
import net.flugi.perpetuality.component.ModDataComponentTypes;

public class LanternItem extends Item {
    public LanternItem(Settings settings) { super(settings); }

    private static final int MAX_CHARGE = 900;
    private int ITEM_BAR_COLOR = ColorHelper.fromFloats(1F,0.77F, 0.53F, 0.88F);


    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        ItemStack stack = user.getStackInHand(hand);

        if (!stack.get(ModDataComponentTypes.LANTERN_COOLDOWN)) {
            user.swingHand(hand);

            user.setAttached(ModEntities.CONTRADICTORY, Unit.INSTANCE);
            //user.removeAttached(ModEntities.CONTRADICTORY);


            if (world.isClient()) {
                MinecraftClient client = MinecraftClient.getInstance();
                client.worldRenderer.reload();
            }

            if (!world.isClient()) {

                if (stack.get(ModDataComponentTypes.LANTERN_STATE)) {
                    stack.set(ModDataComponentTypes.LANTERN_STATE, false);
                    world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS);
                } else if (!stack.get(ModDataComponentTypes.LANTERN_STATE)) {
                    user.getStackInHand(hand).set(ModDataComponentTypes.LANTERN_STATE, true);
                    world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS);
                }

                if (user instanceof PlayerEntity player) {
                    if (!player.getItemCooldownManager().isCoolingDown(stack)) {
                        player.getItemCooldownManager().set(stack, 8);
                    }
                }
                //Perpetuality.LOGGER.info(String.valueOf(user.getStackInHand(hand)));
                //Perpetuality.LOGGER.info(String.valueOf(user.getStackInHand(hand).get(ModDataComponentTypes.LANTERN_STATE)));
            }

        }
        return super.use(world, user, hand);
    }


    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {

        boolean isCurrentlyHeld = ((entity instanceof PlayerEntity player && ( player.getOffHandStack() == stack ||  player.getStackInHand(player.getActiveHand()) == stack)));




        if (stack.get(ModDataComponentTypes.LANTERN_COOLDOWN)) {
            ITEM_BAR_COLOR = ColorHelper.fromFloats(1F,0.66F, 0.66F, 0.66F); // winging my ding until i gaster
        } else {
            ITEM_BAR_COLOR = ColorHelper.fromFloats(1F,0.77F, 0.53F, 0.88F);
        }


        if (!world.isClient()) {
            int currentCharge = stack.get(ModDataComponentTypes.LANTERN_CHARGE);

            if (stack.get(ModDataComponentTypes.LANTERN_STATE) && currentCharge >0 && isCurrentlyHeld) {
                stack.set(ModDataComponentTypes.LANTERN_CHARGE,currentCharge-3);
            } else if (!stack.get(ModDataComponentTypes.LANTERN_STATE) && currentCharge < MAX_CHARGE) {
                stack.set(ModDataComponentTypes.LANTERN_CHARGE,currentCharge+1);
            } else if (currentCharge <= 0) {
                stack.set(ModDataComponentTypes.LANTERN_STATE, false);
                stack.set(ModDataComponentTypes.LANTERN_COOLDOWN,true);
                //if (entity instanceof PlayerEntity player) {player.getItemCooldownManager().set(stack, MAX_CHARGE-10);}

                world.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS);
                world.playSound(null, entity.getBlockPos(), SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS);
            } else if (stack.get(ModDataComponentTypes.LANTERN_CHARGE) == MAX_CHARGE && stack.get(ModDataComponentTypes.LANTERN_COOLDOWN)) {
                stack.set(ModDataComponentTypes.LANTERN_COOLDOWN,false);
            }

            // Perpetuality.LOGGER.info(String.valueOf(stack.get(ModDataComponentTypes.LANTERN_CHARGE)));
        }

        super.inventoryTick(stack, world, entity, slot);
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
