package net.boblercat.tutorialmod.item;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.item.custom.*;
import net.fabricmc.fabric.api.client.networking.v1.C2SPlayChannelEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
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
    public static final Item RANDOM_ORB = registerItem("random_orb",new Item(new FabricItemSettings()){
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Craft a random item from the random orb loot pool"));
        }
    });
    public static final Item TOMATO = registerItem("tomato",new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COOLER_COAL = registerItem("cooler_coal",new Item(new FabricItemSettings()));

    public static final Item ZYNITE_PICKAXE = registerItem("zynite_pickaxe"
            ,new PickaxeItem(ModToolMaterial.ZYNITE,1,1.4f -4 , new FabricItemSettings()));
    public static final Item ZYNITE_SHOVEL = registerItem("zynite_shovel"
            ,new ShovelItem(ModToolMaterial.ZYNITE,0,1.2f -4, new FabricItemSettings()));
    public static final Item ZYNITE_AXE = registerItem("zynite_axe"
            ,new AxeItem(ModToolMaterial.ZYNITE,6.5f,1.25f -4 , new FabricItemSettings()));
    public static final Item ZYNITE_SWORD = registerItem("zynite_sword"
            ,new SwordItem(ModToolMaterial.ZYNITE,4,1.85f -4 , new FabricItemSettings()));
    public static final Item ZYNITE_HOE = registerItem("zynite_hoe"
            ,new HoeItem(ModToolMaterial.ZYNITE,-3,0, new FabricItemSettings()));

    public static final Item ZYNITE_HELMET = registerItem("zynite_helmet"
            ,new ModArmorItem(ModArmorMaterials.ZYNITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ZYNITE_CHESTPLATE = registerItem("zynite_chestplate"
            ,new ArmorItem(ModArmorMaterials.ZYNITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ZYNITE_LEGGINGS = registerItem("zynite_leggings"
            ,new ArmorItem(ModArmorMaterials.ZYNITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ZYNITE_BOOTS = registerItem("zynite_boots"
            ,new ArmorItem(ModArmorMaterials.ZYNITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP,new FabricItemSettings()));
    public static final Item LORE_SCROLL = registerItem("lore_scroll",new LoreScrollItem(new FabricItemSettings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.literal("Access a random lore entry that someone wrote with the /addlore command"));
        }
    });
    public static final Item UNSTABLE_ORB = registerItem("unstable_orb",new UnstableOrbItem(new FabricItemSettings()));
    public static final Item WITHERING_SHANK = registerItem("withering_shank",new WitheringShankItem(new FabricItemSettings().maxDamage(1)));
    public static final Item EFFECT_BANK = registerItem("effect_bank",
            new EffectBankItem(new FabricItemSettings().maxCount(1)){
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.literal("Store up to 3 Effects that anyone with the bank can release"));
                }
            });

    public static final Item INDEX_ORB = registerItem("index_orb",new Item(new FabricItemSettings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.translatable("item.tutorialmod.index_orb.tooltip"));
            tooltip.add(Text.literal("(Per Session: resets once you leave and rejoin)"));
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
