package net.flugi.perpetuality.recipe;

import net.flugi.perpetuality.Perpetuality;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes  {

    public static final PotRecipeCerealiser POT_RECIPE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER,
            Identifier.of(Perpetuality.MOD_ID, "pot"),
            new PotRecipeCerealiser()
    );

    public static final RecipeType<PotRecipe> POT_RECIPE_TYPE = Registry.register(
            Registries.RECIPE_TYPE,
            Identifier.of(Perpetuality.MOD_ID, "pot"),
            new RecipeType<PotRecipe>() {}
    );

    public static void initialize() {
    }
}
