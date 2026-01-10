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
    private static final List<Item> REWARD_POOL = new ArrayList<>();

    static {
        REWARD_POOL.add(Items.DIAMOND);
        REWARD_POOL.add(Items.DIRT);
        REWARD_POOL.add(Items.ENCHANTED_GOLDEN_APPLE);
        REWARD_POOL.add(Moditems.ZYNITE);
    }

    public MysteryItemRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        // Loop through the grid
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (stack.getItem() == Moditems.ORB_OF_RANDOM) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        // Pick a random item
        Random random = new Random();
        int randomIndex = random.nextInt(MysteryItemRecipe.REWARD_POOL.size());

        return new ItemStack(MysteryItemRecipe.REWARD_POOL.get(randomIndex));
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

