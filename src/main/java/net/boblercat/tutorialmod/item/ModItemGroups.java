package net.boblercat.tutorialmod.item;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ZYNITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"zynite"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.zynite"))
                    .icon(()-> new ItemStack(Moditems.ZYNITE)).entries((displayContext, entries) -> {
                        entries.add(Moditems.ZYNITE);
                        entries.add(Moditems.PURE_ZYNITE);
                        entries.add(Moditems.RAW_ZYNITE);
                        entries.add(ModBlocks.ZYNITE_BLOCK);

                    }).build());


    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
