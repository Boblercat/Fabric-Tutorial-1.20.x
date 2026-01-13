package net.boblercat.tutorialmod.item;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MysteryItemRecipe extends SpecialCraftingRecipe {
    public static final List<Item> REWARD_POOL = new ArrayList<>();

    static {
        REWARD_POOL.add(Moditems.RANDOM_ORB);
    }

    public MysteryItemRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        boolean foundOrb = false;

        // Loop through every slot in the grid
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);

            // If the slot is empty, ignore it and check the next one
            if (stack.isEmpty()) {
                continue;
            }

            // If we find an item that is NOT the orb, the recipe fails immediately
            if (stack.getItem() != Moditems.RANDOM_ORB) {
                return false;
            }

            // If we reach here, the item IS the orb.
            // But if we already found an orb before (foundOrb is true),
            // that means there are TWO orbs. The recipe should fail.
            if (foundOrb) {
                return false;
            }

            // Mark that we found the first valid orb
            foundOrb = true;
        }

        // Return true only if we found exactly one orb (and no junk items caused a false earlier)
        return foundOrb;
    }


    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        // Picks unstable Orb
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

