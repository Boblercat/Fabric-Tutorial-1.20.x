package net.boblercat.tutorialmod.recipes;

import net.boblercat.tutorialmod.TutorialMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

        public static final RecipeSerializer<MysteryItemRecipe> MYSTERY_RECIPE_SERIALIZER =
                new SpecialRecipeSerializer<>(MysteryItemRecipe::new);
        public static final RecipeSerializer<IndexItemRecipe> INDEX_RECIPE_SERIALIZER =
                new SpecialRecipeSerializer<>(IndexItemRecipe::new);

    public static void registerRecipes() {
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    new Identifier("tutorialmod", "orb_recipe"),
                    MYSTERY_RECIPE_SERIALIZER
            );
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    new Identifier("tutorialmod", "index_recipe"),
                    INDEX_RECIPE_SERIALIZER
            );
            TutorialMod.LOGGER.info("Registering Mod Recipes for " + TutorialMod.MOD_ID);
        }
    }

