package net.flugi.perpetuality.block.custom;

import com.mojang.serialization.MapCodec;
import net.flugi.perpetuality.block.entity.ModBlockEntities;
import net.flugi.perpetuality.block.entity.custom.PotBlockEntity;

import net.flugi.perpetuality.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jspecify.annotations.Nullable;
import net.minecraft.item.Items;

public class PotBlock extends BlockWithEntity {

    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public static final IntProperty LEVEL = IntProperty.of("level",0,6);
    public static final BooleanProperty WATER = BooleanProperty.of("water");

    private static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createColumnShape(16,0,4),
            Block.createColumnShape(12,4,11)
    );


    public PotBlock(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
        setDefaultState(getDefaultState().with(LEVEL, 0));
        setDefaultState(getDefaultState().with(WATER, false));
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(PotBlock::new);
    }

    @Nullable
    @Override
    public  BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PotBlockEntity(pos, state);
    }


    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof PotBlockEntity potBlockEntity) {

            boolean IS_FULL = state.get(WATER);

            if (world.isClient()) {
                // this is just cuz i want the sound to play and im a stupid chud so uhh idk yea
                if (!IS_FULL && state.get(LEVEL) == 0 && stack.getItem() == Items.WATER_BUCKET) {
                    world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }
            }else{

            //filling with water
            if (!IS_FULL && potBlockEntity.getIngredientCount() ==0 && stack.getItem() == Items.WATER_BUCKET){
                stack.decrementUnlessCreative(1, player);
                if (!player.isInCreativeMode()){player.giveOrDropStack(new ItemStack(Items.BUCKET));}
                world.setBlockState(pos, state.with(WATER, true));
                world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                return ActionResult.SUCCESS_SERVER;
            }

            // setup/first stew

            if (IS_FULL && potBlockEntity.addIngredient(player, stack)) {
                //player.sendMessage(Text.literal(String.valueOf(potBlockEntity.getStewIngredients())), true);
                return ActionResult.SUCCESS_SERVER;
            }


            // non setup normal perpetual stew shit
            if (potBlockEntity.getIngredientCount() >0 && !IS_FULL ) {
                if ((potBlockEntity.addIngredient(player, stack) || potBlockEntity.collectStew( player, stack, (ServerWorld) world))) {
                    world.setBlockState(pos, state.with(LEVEL, potBlockEntity.getIngredientCount()));
                    return ActionResult.SUCCESS_SERVER;
                }
            }
        }}
        return ActionResult.CONSUME;
    }


    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }



    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }
    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING).add(LEVEL).add(WATER);
    }


    public static int getLuminance(BlockState currentBlockState) {
        return 10 ;
    }


    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos, Direction direction) {
        if ((world.getBlockEntity(pos) instanceof PotBlockEntity potBlockEntity)) {
            return Math.round((float) potBlockEntity.getIngredientCount()/6*15);
        }
        return 0;
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(20) == 0) {
            world.playSoundClient(
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    SoundEvents.BLOCK_CAMPFIRE_CRACKLE,
                    SoundCategory.BLOCKS,
                    0.25F + random.nextFloat()/3,
                    random.nextFloat() * 0.7F + 0.6F,
                    false
            );
        }

    }

    @Override
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.POT_BLOCK_ENTITY, PotBlockEntity::tick);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModItems.CROCKPOT);
    }
}

