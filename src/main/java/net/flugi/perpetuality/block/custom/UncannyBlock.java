package net.flugi.perpetuality.block.custom;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.flugi.perpetuality.Perpetuality;

import net.flugi.perpetuality.component.ModDataComponentTypes;
import net.flugi.perpetuality.damage.ModDamageTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class UncannyBlock extends Block {
    public UncannyBlock(Settings settings) {
        super(settings);
    }
    public boolean shouldWeShowACatPicToThisMF = false;
    private static final VoxelShape SHAPE = Block.createColumnShape(14.0, 1.0, 15.0);

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {

        if (entity instanceof LivingEntity && world instanceof ServerWorld serverWorld) {

            if (entity.isPlayer()) {

            }

            DamageSource damageSource = new DamageSource(RegistryEntry.of(world.getRegistryManager()
                    .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                    .get(ModDamageTypes.UNCANNY_DAMAGE)));

            entity.damage(serverWorld, damageSource, 2000f);
        }

        if (world.isClient()) {
            /*HudRenderCallback.EVENT.register(((drawContext, renderTickCounter) -> {

                int screenWidth = drawContext.getScaledWindowWidth();
                int screenHeight = drawContext.getScaledWindowHeight();
                Identifier texture = Identifier.of(Perpetuality.MOD_ID, "textures/uncanny.png");
                drawContext.drawTexture(RenderPipelines.GUI_TEXTURED, texture, 0, 0, 0, 0, screenWidth, screenHeight,screenWidth,screenHeight);

            }));*/
        }



        super.onEntityCollision(state, world, pos, entity, handler, bl);
    }

    @Override
    protected void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        super.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }



}
