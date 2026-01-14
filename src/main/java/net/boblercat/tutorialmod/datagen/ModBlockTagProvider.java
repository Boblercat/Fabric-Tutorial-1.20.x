package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.utill.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super (output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.ZYNITE_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES)
                ;
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ZYNITE_ORE)
                .add(ModBlocks.DEEPSLATE_ZYNITE_ORE)
                .add(ModBlocks.NETHER_ZYNITE_ORE)
                .add(ModBlocks.END_STONE_ZYNITE_ORE)
                .add(ModBlocks.ZYNITE_BLOCK)
                .add(ModBlocks.RAW_ZYNITE_BLOCK)
                .add(ModBlocks.SOUNDBLOCK)
                ;
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        ;
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.ZYNITE_BLOCK)
                .add(ModBlocks.ZYNITE_ORE)
                .add(ModBlocks.NETHER_ZYNITE_ORE)
                .add(ModBlocks.END_STONE_ZYNITE_ORE)
                .add(ModBlocks.DEEPSLATE_ZYNITE_ORE)
                .add(ModBlocks.RAW_ZYNITE_BLOCK)
                ;
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK,new Identifier("fabric","needs_tool_level_5")));
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ZYNITE_FENCE)
        ;
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ZYNITE_FENCE_GATE)
        ;
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ZYNITE_WALL)
        ;
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.ZYNITE_DOOR)
        ;
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.ZYNITE_TRAPDOOR)
        ;
    }
}
