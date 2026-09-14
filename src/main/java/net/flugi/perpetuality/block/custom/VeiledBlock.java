package net.flugi.perpetuality.block.custom;

//import net.flugi.perpetuality.bulshittt.ModEntities;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import java.util.function.Function;
import java.util.function.Supplier;

public class VeiledBlock extends TransparentBlock {

    public static Function<Settings, Block> of(boolean hidden) {
        return settings -> new VeiledBlock(settings, hidden);
    }

    private boolean hidden;



    public VeiledBlock(Settings settings, boolean hidden) {
        super(settings);
        this.hidden = hidden;
    }

    public static Supplier<Boolean> solid = () -> false;

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((!solid.get() ^ hidden)) {
            return VoxelShapes.fullCube();
        }
        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (!solid.get() ^ hidden) {
            return VoxelShapes.fullCube();
        }
        return VoxelShapes.empty();
    }

    /*@Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        return (context.getPlayer().hasAttached(ModEntities.CONTRADICTORY) ^ hidden);
    }*/

    /*
    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if ((!solid.get() ^ hidden) || !world.isClient() ) { return super.canPlaceAt(state, world, pos); }
        return false;
    }
    */

    public static Function<BlockState, BlockRenderType> cb = null;

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        cb = STATE -> solid.get() ^ hidden ? BlockRenderType.INVISIBLE : BlockRenderType.MODEL;
        if (cb != null) return cb.apply(state);
        return super.getRenderType(state);
    }

    @Override
    protected float getMaxHorizontalModelOffset() {
        return super.getMaxHorizontalModelOffset();
    }


}

