package nebula.primordia.recipe;

import nebula.primordia.Primordia;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<ForgeRecipe> FORGE_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Primordia.MOD_ID, "forge"),
            new ForgeRecipe.Serializer());
    public static final RecipeType<ForgeRecipe> FORGE_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Primordia.MOD_ID, "forge"), new RecipeType<ForgeRecipe>() {
                @Override
                public String toString() {
                    return "growth_chamber";
                }
            });

    public static void registerRecipes() {
        Primordia.LOGGER.info("Registering Custom Recipes for " + Primordia.MOD_ID);
    }
}