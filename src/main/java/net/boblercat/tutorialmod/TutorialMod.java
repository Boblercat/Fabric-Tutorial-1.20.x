package net.boblercat.tutorialmod;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.command.ModCommands;
import net.boblercat.tutorialmod.datagen.ModWorldGenerator;
import net.boblercat.tutorialmod.effects.ModStatusEffects;
import net.boblercat.tutorialmod.item.ModItemGroups;
import net.boblercat.tutorialmod.recipes.ModRecipes;
import net.boblercat.tutorialmod.item.Moditems;
import net.boblercat.tutorialmod.sound.ModSounds;
import net.boblercat.tutorialmod.utill.LoreManager;
import net.boblercat.tutorialmod.utill.ModLootTableModifiers;
import net.boblercat.tutorialmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TutorialMod implements ModInitializer {
	//public static final Set<UUID> JACKPOT_PLAYERS = new HashSet<>();
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier JACKPOT_PACKET_ID = new Identifier(MOD_ID, "play_jackpot_music");

	@Override
	public void onInitialize() {

		/**ServerTickEvents.START_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

				boolean hasJackpot = false;
				if (player.hasStatusEffect(ModStatusEffects.JACKPOT)) {
					if (player.getStatusEffect(ModStatusEffects.JACKPOT).getAmplifier() == 0) {
						hasJackpot = true;
					}
				}

				// Logic: If they lost the effect since last tick
				if (JACKPOT_PLAYERS.contains(player.getUuid()) && !hasJackpot) {

					// --- THE FIX IS HERE ---
					player.networkHandler.sendPacket(new StopSoundS2CPacket(
							new Identifier("tutorialmod", "jackpot_music"), // Manually typed ID
							SoundCategory.MUSIC
					));

					JACKPOT_PLAYERS.remove(player.getUuid());
				}

				if (hasJackpot) {
					JACKPOT_PLAYERS.add(player.getUuid());
				}
			}
		});
		 **/
		ModItemGroups.registerItemGroups();
		Moditems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRecipes.registerRecipes();
		ModStatusEffects.registerModEffects();
		ModLootTableModifiers.modifyLootTables();
		ModWorldGeneration.generateModWorldGen();
		ModCommands.register();
		LoreManager.loadLore();

		//net.boblercat.tutorialmod.utill.RewardDataManager.load();

		FuelRegistry.INSTANCE.add(Moditems.COOLER_COAL,2800);

		LOGGER.info("Hello Fabric world!");
	}
}