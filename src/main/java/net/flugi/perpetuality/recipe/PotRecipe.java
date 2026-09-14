package net.flugi.perpetuality.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

import java.util.List;

public class PotRecipe implements Recipe<PotRecipeInput> {
    private final ItemStack result;
    private final List<Ingredient> ingredients;


    public PotRecipe(ItemStack result, List<Ingredient> ingredients) {
        this.result = result;
        this.ingredients = ingredients;


    }

    public ItemStack getResult() {
        return result;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean matches(PotRecipeInput input, World world) {
        // probably not the best way to do it but, it works soooooo
        // feel free to find a better solution if you want :sob:
        boolean conditionmet;
        boolean should = true;
        for (Ingredient condition : ingredients) {
            conditionmet = false;
            for (int i = 0; i < input.size(); i++) {

                conditionmet = conditionmet || condition.test(input.getStackInSlot(i));
            }
            should = should && conditionmet;
        }
        return should;
    }

    @Override
    public ItemStack craft(PotRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<PotRecipeInput>> getSerializer() {
        return ModRecipes.POT_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<PotRecipeInput>> getType() {
        return ModRecipes.POT_RECIPE_TYPE;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return null;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.NONE;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }
}
