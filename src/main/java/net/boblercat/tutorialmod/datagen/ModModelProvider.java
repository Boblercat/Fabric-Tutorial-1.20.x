package net.boblercat.tutorialmod.datagen;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool zynitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ZYNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ZYNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_ZYNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUNDBLOCK);

        zynitePool.stairs(ModBlocks.ZYNITE_STAIRS);
        zynitePool.slab(ModBlocks.ZYNITE_SLAB);
        zynitePool.button(ModBlocks.ZYNITE_BUTTON);
        zynitePool.fence(ModBlocks.ZYNITE_FENCE);
        zynitePool.fenceGate(ModBlocks.ZYNITE_FENCE_GATE);
        zynitePool.wall(ModBlocks.ZYNITE_WALL);
        zynitePool.pressurePlate(ModBlocks.ZYNITE_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor((ModBlocks.ZYNITE_DOOR));
        blockStateModelGenerator.registerTrapdoor((ModBlocks.ZYNITE_TRAPDOOR));
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

        itemModelGenerator.register(Moditems.ZYNITE_SWORD,Models.HANDHELD);
        itemModelGenerator.register(Moditems.ZYNITE_HOE,Models.HANDHELD);
        itemModelGenerator.register(Moditems.ZYNITE_PICKAXE,Models.HANDHELD);
        itemModelGenerator.register(Moditems.ZYNITE_AXE,Models.HANDHELD);
        itemModelGenerator.register(Moditems.ZYNITE_SHOVEL,Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) Moditems.ZYNITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.ZYNITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.ZYNITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) Moditems.ZYNITE_BOOTS));

    }
}
