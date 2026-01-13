package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ZYNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZYNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUNDBLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(Moditems.ZYNITE, Models.GENERATED);
        itemModelGenerator.register(Moditems.RAW_ZYNITE, Models.GENERATED);

        itemModelGenerator.register(Moditems.COOLER_COAL, Models.GENERATED);
        itemModelGenerator.register(Moditems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(Moditems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(Moditems.INDEX_ORB, Models.GENERATED);
        itemModelGenerator.register(Moditems.RANDOM_ORB, Models.GENERATED);
        itemModelGenerator.register(Moditems.UNSTABLE_ORB, Models.GENERATED);
        itemModelGenerator.register(Moditems.PURE_ZYNITE, Models.GENERATED);

    }
}
