package net.boblercat.tutorialmod.recipes;

import net.boblercat.tutorialmod.item.Moditems;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class MysteryItemRecipe extends SpecialCraftingRecipe {
    public static final List<Item> REWARD_POOL = new ArrayList<>();

    static {
        REWARD_POOL.add(Moditems.RANDOM_ORB);
    }

    public MysteryItemRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        boolean foundOrb = false;


        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);


            if (stack.isEmpty()) {
                continue;
            }


            if (stack.getItem() != Moditems.RANDOM_ORB) {
                return false;
            }


            if (foundOrb) {
                return false;
            }


            foundOrb = true;
        }


        return foundOrb;
    }


    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {

        return new ItemStack(Moditems.UNSTABLE_ORB);
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 1;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.MYSTERY_RECIPE_SERIALIZER;
    }
}

