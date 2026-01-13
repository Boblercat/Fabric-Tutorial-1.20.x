package net.boblercat.tutorialmod.item;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.item.custom.MetalDetectorItem;
import net.boblercat.tutorialmod.item.custom.UnstableOrbItem;
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Moditems {
    public static final Item ZYNITE = registerItem("zynite",new Item(new FabricItemSettings()));
    public static final Item RAW_ZYNITE = registerItem("raw_zynite",new Item(new FabricItemSettings()));
    public static final Item PURE_ZYNITE = registerItem("pure_zynite",new Item(new FabricItemSettings()));
    public static final Item RANDOM_ORB = registerItem("random_orb",new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COOLER_COAL = registerItem("cooler_coal",new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));
    public static final Item UNSTABLE_ORB = registerItem("unstable_orb",new UnstableOrbItem(new FabricItemSettings()));
    public static final Item INDEX_ORB = registerItem("index_orb",new Item(new FabricItemSettings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.translatable("item.tutorialmod.index_orb.tooltip"));
            tooltip.add(Text.literal("(Hint: Put the Index Orb and another item in the Crafting Table)"));

        }
    });

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(ZYNITE);
        entries.add(Moditems.PURE_ZYNITE);
        entries.add(RAW_ZYNITE);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items For " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Moditems::addItemsToIngredientItemGroup);
    }
}
