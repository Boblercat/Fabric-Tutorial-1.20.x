package net.boblercat.tutorialmod.block;

import net.boblercat.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ZYNITE_BLOCK = registerBlock("zynite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_ZYNITE_BLOCK = registerBlock("raw_zynite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).sounds(BlockSoundGroup.DECORATED_POT_SHATTER)));


    private static Block registerBlock(String name, Block block){
        registerBlockItems(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItems(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }
}
