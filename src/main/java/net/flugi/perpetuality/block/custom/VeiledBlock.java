package net.flugi.perpetuality.block.custom;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

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
        if (!solid.get() ^ hidden) {
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

    public static Function<BlockState, BlockRenderType> cb = null;

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        if (cb != null) return cb.apply(state);
        return super.getRenderType(state);
    }


    @Override
    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        return (solid.get() ^ hidden);
    }
}
