package net.flugi.perpetuality.item.custom;

import net.flugi.perpetuality.block.ModBlocks;
import net.flugi.perpetuality.block.custom.PotBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class CrockPotItem extends Item{

    public CrockPotItem(Item.Settings settings) { super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        BlockState target = world.getBlockState(pos);

            if (target.getBlock() == Blocks.CAMPFIRE) {
                world.addBlockBreakParticles(pos,target);
                world.playSoundFromEntity(context.getPlayer(),context.getPlayer(), SoundEvents.BLOCK_DECORATED_POT_PLACE, SoundCategory.BLOCKS,0.75f,1f);
                if (!world.isClient()) {
                    Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getHand()).decrementUnlessCreative(1,context.getPlayer());
                    Direction facing = target.get(CampfireBlock.FACING);
                    world.setBlockState(pos, ModBlocks.CROCKPOT_BLOCK.getDefaultState().with(PotBlock.FACING,facing));
                }
                return ActionResult.SUCCESS;
            }
        return ActionResult.FAIL;
    }



}
