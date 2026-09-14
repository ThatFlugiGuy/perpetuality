package net.flugi.perpetuality.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

import java.util.List;

public class PotRecipeInput implements RecipeInput {

    private final List<ItemStack> stacks;
    private final int stackCount;
    public PotRecipeInput(List<ItemStack> stacks) {
        this.stacks = stacks;

        int i = 0;

        for (ItemStack itemStack : stacks) {
            if (!itemStack.isEmpty()) {
                i++;
            }
        }

        this.stackCount = i;

    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.stacks.get(slot);
    }

    @Override
    public int size() {
        return this.stacks.size();
    }



}
