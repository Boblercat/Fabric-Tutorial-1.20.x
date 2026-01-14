package net.boblercat.tutorialmod.world;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ZYNITE_ORE_PLACED_KEY = registerKey("zynite_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_ZYNITE_ORE_PLACED_KEY = registerKey("nether_zynite_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ZYNITE_ORE_PLACED_KEY = registerKey("end_zynite_ore_placed");

    public static void boostrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,ZYNITE_ORE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ZYNITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64),YOffset.fixed(10))));
        register(context,NETHER_ZYNITE_ORE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ZYNITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10),YOffset.fixed(118))));
        register(context,END_ZYNITE_ORE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_ZYNITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10),YOffset.fixed(80))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(TutorialMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
