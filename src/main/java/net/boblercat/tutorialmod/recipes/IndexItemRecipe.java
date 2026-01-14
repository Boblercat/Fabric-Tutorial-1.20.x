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

public class IndexItemRecipe extends SpecialCraftingRecipe {


    public IndexItemRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        boolean foundFixedItem = false;
        boolean foundDynamicItem = false;

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            if (stack.isEmpty()) continue;

            // CHECK 1: Is this your specific fixed item?
            if (stack.getItem() == Moditems.INDEX_ORB) { // <--- REPLACE THIS
                if (foundFixedItem) return false; // Fail if we found two Orbs
                foundFixedItem = true;
            }
            // CHECK 2: If it's not the fixed item, it must be the Dynamic one
            else {
                if (foundDynamicItem) return false; // Fail if we found two random items

                // OPTIONAL: Add a check here if you only want it to work on Swords, Tools, etc.
                // if (!stack.getItem().isDamageable()) return false;

                foundDynamicItem = true;
            }
        }

        return foundFixedItem && foundDynamicItem;
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager registryManager) {
        for(int i = 0; i <inventory.size();i++){
            ItemStack stack = inventory.getStack(i);
            if (stack.isEmpty()|| stack.getItem() == Moditems.INDEX_ORB){
                continue;
            }
            Item victimItem = stack.getItem();

            if(!MysteryItemRecipe.REWARD_POOL.contains(victimItem)){
                MysteryItemRecipe.REWARD_POOL.add(victimItem);
            }
            break;
        }
        return new ItemStack(Moditems.INDEX_ORB);
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.INDEX_RECIPE_SERIALIZER;
    }
}
