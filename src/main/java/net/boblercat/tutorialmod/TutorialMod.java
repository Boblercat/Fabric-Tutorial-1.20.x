package net.boblercat.tutorialmod;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.effects.ModStatusEffects;
import net.boblercat.tutorialmod.item.ModItemGroups;
import net.boblercat.tutorialmod.recipes.ModRecipes;
import net.boblercat.tutorialmod.item.Moditems;
import net.boblercat.tutorialmod.utill.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		Moditems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRecipes.registerRecipes();
		ModStatusEffects.registerModEffects();
		ModLootTableModifiers.modifyLootTables();
		//net.boblercat.tutorialmod.utill.RewardDataManager.load();

		FuelRegistry.INSTANCE.add(Moditems.COOLER_COAL,2800);

		LOGGER.info("Hello Fabric world!");
	}
}