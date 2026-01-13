package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.item.ModRecipes;
import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> ZYNITE_SMELTABLES = List.of(Moditems.RAW_ZYNITE,
            ModBlocks.ZYNITE_ORE,ModBlocks.DEEPSLATE_ZYNITE_ORE,ModBlocks.NETHER_ZYNITE_ORE,ModBlocks.END_STONE_ZYNITE_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, ZYNITE_SMELTABLES, RecipeCategory.MISC, Moditems.ZYNITE,
                0.9f,250,"zynite");
        offerBlasting(exporter, ZYNITE_SMELTABLES, RecipeCategory.MISC, Moditems.ZYNITE,
                0.9f,110,"zynite");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,Moditems.ZYNITE,RecipeCategory.DECORATIONS,ModBlocks.ZYNITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Moditems.ZYNITE,1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('R',Moditems.ZYNITE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
                .offerTo(exporter,new Identifier(getRecipeName(Moditems.RAW_ZYNITE)));
        offerShapelessRecipe(exporter, Blocks.NOTE_BLOCK,ModBlocks.SOUNDBLOCK,"redstone",1);
        offerShapelessRecipe(exporter, ModBlocks.SOUNDBLOCK,Blocks.NOTE_BLOCK,"redstone",1);
        ComplexRecipeJsonBuilder.create(ModRecipes.MYSTERY_RECIPE_SERIALIZER)
                .offerTo(exporter,"orb_recipe");
        ComplexRecipeJsonBuilder.create(ModRecipes.INDEX_RECIPE_SERIALIZER)
                .offerTo(exporter,"index_recipe");
        offerShapelessRecipe(exporter,ModBlocks.ZYNITE_BUTTON,Moditems.ZYNITE,"redstone",1);
        offerSlabRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.ZYNITE_SLAB,ModBlocks.ZYNITE_BLOCK);
        offerPressurePlateRecipe(exporter,ModBlocks.ZYNITE_PRESSURE_PLATE,Moditems.ZYNITE);
        offerWallRecipe(exporter,RecipeCategory.BUILDING_BLOCKS,ModBlocks.ZYNITE_WALL,ModBlocks.ZYNITE_BLOCK);
        createDoorRecipe(ModBlocks.ZYNITE_DOOR, Ingredient.ofItems(Moditems.ZYNITE))
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.ZYNITE_DOOR)));
        createTrapdoorRecipe(ModBlocks.ZYNITE_TRAPDOOR, Ingredient.ofItems(Moditems.ZYNITE))
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.ZYNITE_TRAPDOOR)));
        createStairsRecipe(ModBlocks.ZYNITE_STAIRS, Ingredient.ofItems(ModBlocks.ZYNITE_BLOCK))
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.ZYNITE_STAIRS)));
        createFenceGateRecipe(ModBlocks.ZYNITE_FENCE_GATE, Ingredient.ofItems(Moditems.ZYNITE))
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.ZYNITE_FENCE_GATE)));
        createFenceRecipe(ModBlocks.ZYNITE_FENCE, Ingredient.ofItems(Moditems.ZYNITE))
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.ZYNITE_FENCE)));
    }
}
