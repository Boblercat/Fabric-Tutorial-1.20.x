package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.recipes.ModRecipes;
import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
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
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, ZYNITE_SMELTABLES, RecipeCategory.MISC, Moditems.ZYNITE,
                0.9f,250,"zynite");
        offerBlasting(exporter, ZYNITE_SMELTABLES, RecipeCategory.MISC, Moditems.ZYNITE,
                0.9f,110,"zynite");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,Moditems.ZYNITE,RecipeCategory.DECORATIONS,ModBlocks.ZYNITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Moditems.RAW_ZYNITE,1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('R',Moditems.ZYNITE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.STONE),conditionsFromItem(Items.STONE))
                .offerTo(exporter,new Identifier(getRecipeName(Moditems.RAW_ZYNITE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Moditems.RANDOM_ORB,2)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.AMETHYST_SHARD)
                .input('R',Moditems.RANDOM_ORB)
                .criterion(hasItem(Moditems.RANDOM_ORB),conditionsFromItem(Moditems.RANDOM_ORB))
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,Moditems.INDEX_ORB,1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('R', Items.AMETHYST_SHARD)
                .input('S',Items.BOOKSHELF)
                .criterion(hasItem(Moditems.RANDOM_ORB),conditionsFromItem(Moditems.RANDOM_ORB))
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BREWING,Moditems.EFFECT_BANK,1)
                .pattern("BBB")
                .pattern("SRB")
                .pattern("SSS")
                .input('R', Moditems.INDEX_ORB)
                .input('S',Items.BOOK)
                .input('B',Items.GLASS_BOTTLE)
                .criterion(hasItem(Moditems.INDEX_ORB),conditionsFromItem(Moditems.RANDOM_ORB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.WITHERING_SHANK,1)
                .pattern(" B ")
                .pattern(" R ")
                .pattern(" S ")
                .input('R', Items.IRON_NUGGET)
                .input('S',Items.STICK)
                .input('B',Items.WITHER_ROSE)
                .criterion(hasItem(Moditems.INDEX_ORB),conditionsFromItem(Moditems.RANDOM_ORB))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS,Moditems.METAL_DETECTOR,1)
                .pattern(" * ")
                .pattern("IDI")
                .pattern(" A ")
                .input('A', Items.ANVIL)
                .input('*',Items.NETHER_STAR)
                .input('D',Items.DIAMOND)
                .input('I',Items.IRON_BLOCK)
                .criterion(hasItem(Items.IRON_BLOCK),conditionsFromItem(Items.IRON_BLOCK))
                .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                .criterion(hasItem(Items.ANVIL),conditionsFromItem(Items.ANVIL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_HELMET,1)
                .pattern("***")
                .pattern("*G*")
                .pattern(" S ")
                .input('G', Items.NETHERITE_HELMET)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_CHESTPLATE,1)
                .pattern("*G*")
                .pattern("*E*")
                .pattern("*S*")
                .input('G', Items.NETHERITE_CHESTPLATE)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .input('E',Items.NETHER_STAR)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_LEGGINGS,1)
                .pattern("*G*")
                .pattern("*S*")
                .pattern("* *")
                .input('G', Items.NETHERITE_LEGGINGS)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_BOOTS,1)
                .pattern("   ")
                .pattern("*G*")
                .pattern("*S*")
                .input('G', Items.NETHERITE_BOOTS)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_SWORD,1)
                .pattern("   ")
                .pattern("*G*")
                .pattern(" S ")
                .input('G', Items.NETHERITE_SWORD)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_PICKAXE,1)
                .pattern("***")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', Items.NETHERITE_PICKAXE)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_AXE,1)
                .pattern("** ")
                .pattern("*G ")
                .pattern(" S ")
                .input('G', Items.NETHERITE_AXE)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_SHOVEL,1)
                .pattern(" * ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', Items.NETHERITE_SHOVEL)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,Moditems.ZYNITE_HOE,1)
                .pattern("** ")
                .pattern(" G ")
                .pattern(" S ")
                .input('G', Items.NETHERITE_HOE)
                .input('*',Moditems.ZYNITE)
                .input('S',Items.SMITHING_TABLE)
                .criterion(hasItem(Moditems.ZYNITE),conditionsFromItem(Moditems.ZYNITE))
                .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,Moditems.COOLER_COAL,1)
                        .input(Items.COAL)
                        .input(Items.SUGAR)
                        .criterion(hasItem(Items.COAL),conditionsFromItem(Items.COAL))
                        .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR)).offerTo(exporter);

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
