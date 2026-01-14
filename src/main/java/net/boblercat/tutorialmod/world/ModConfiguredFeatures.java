package net.boblercat.tutorialmod.world;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> ZYNITE_ORE_KEY = registerKey("zynite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> NETHER_ZYNITE_ORE_KEY = registerKey("nether_zynite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> END_ZYNITE_ORE_KEY = registerKey("end_zynite_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldZyniteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ZYNITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables,ModBlocks.DEEPSLATE_ZYNITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherZyniteOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_ZYNITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endZyniteOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_STONE_ZYNITE_ORE.getDefaultState()));
    register(context,ZYNITE_ORE_KEY,Feature.ORE,new OreFeatureConfig(overworldZyniteOres,4));
    register(context,NETHER_ZYNITE_ORE_KEY,Feature.ORE,new OreFeatureConfig(netherZyniteOres,6));
    register(context,END_ZYNITE_ORE_KEY,Feature.ORE,new OreFeatureConfig(endZyniteOres,9));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
