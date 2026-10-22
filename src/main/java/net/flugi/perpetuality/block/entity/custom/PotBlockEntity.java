package net.flugi.perpetuality.block.entity.custom;

import net.flugi.perpetuality.Perpetuality;
import net.flugi.perpetuality.block.entity.ModBlockEntities;
import net.flugi.perpetuality.datagen.ModItemTagProvider;
import net.flugi.perpetuality.item.ModItems;
import net.flugi.perpetuality.recipe.ModRecipes;
import net.flugi.perpetuality.recipe.PotRecipe;
import net.flugi.perpetuality.recipe.PotRecipeInput;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class PotBlockEntity extends BlockEntity {
    public PotBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POT_BLOCK_ENTITY, pos, state);
    }


    private int ingredientCount;
    private final DefaultedList<ItemStack> stewIngredients = DefaultedList.ofSize(6, ItemStack.EMPTY);


    private int boilTimer = 0;
    private boolean isReady = false;




    /*
    public void addIngredient(ItemStack stack) {

        stewIngredients.addFirst(stack);
        markDirty();

    }*/

    public boolean addIngredient(@Nullable PlayerEntity entity, ItemStack stack) {
            if (!(stack.isIn(ModItemTagProvider.STEW_INGREDIENTS)) || getIngredientCount()>=6) { return false; }

            stewIngredients.set(ingredientCount,stack.splitUnlessCreative(1,entity));
            markDirty();
            return true;

}


public boolean collectStew(@Nullable LivingEntity entity, ItemStack heldStack, ServerWorld serverWorld) {
    if (!(heldStack.getItem() == Items.BOWL) || getIngredientCount()==0) {return false;}
    heldStack.splitUnlessCreative(1, entity);


    PotRecipeInput recipeInput = new PotRecipeInput(stewIngredients);
    Optional<RecipeEntry<PotRecipe>> recipe = serverWorld.getRecipeManager().getFirstMatch(ModRecipes.POT_RECIPE_TYPE, recipeInput, serverWorld);

    if (recipe.isPresent()) {

        entity.giveOrDropStack(recipe.get().value().craft(recipeInput, serverWorld.getRegistryManager()));
    }
    else {
        entity.giveOrDropStack(new ItemStack(ModItems.GENERIC_STEW));
    }

    //i am not proud of this one

    for (int i = 0; i < getIngredientCount() ; i++) {
        if (!(i==5)) {
        stewIngredients.set(i, stewIngredients.get(i + 1));
        }
    }
    stewIngredients.set(5, ItemStack.EMPTY);
    markDirty();
    return true;
}


    public int getIngredientCount() {
        ingredientCount = 0;

        for (ItemStack stewIngredient : stewIngredients) {
            if (stewIngredient != ItemStack.EMPTY) {
                ingredientCount++;
            }
        }
        //Perpetuality.LOGGER.info(String.valueOf(ingredientCount));
        //markDirty();
        return ingredientCount;
    }

    public DefaultedList<ItemStack> getStewIngredients() {
        return stewIngredients;
    }


    @Override
    protected void writeData(WriteView view) {
        Inventories.writeData(view, this.stewIngredients, true);

        super.writeData(view);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);

        super.readData(view);
        this.stewIngredients.clear();
        Inventories.readData(view, this.stewIngredients);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return super.toInitialChunkDataNbt(registries);
    }
}

