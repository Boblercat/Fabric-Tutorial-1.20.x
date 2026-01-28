package net.boblercat.tutorialmod;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.client.JackpotSoundInstance;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYNITE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYNITE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        ClientPlayNetworking.registerGlobalReceiver(TutorialMod.JACKPOT_PACKET_ID, (client, handler, buf, responseSender) -> {
            int entityId = buf.readInt();

            // 1. Read the Sound ID sent by the server
            Identifier soundId = buf.readIdentifier();

            client.execute(() -> {
                if (client.world != null) {
                    var entity = client.world.getEntityById(entityId);
                    if (entity instanceof PlayerEntity player) {

                        // 2. Convert ID back to a SoundEvent
                        SoundEvent chosenSound = Registries.SOUND_EVENT.get(soundId);

                        // 3. Pass it to the instance
                        client.getSoundManager().play(new JackpotSoundInstance(player, chosenSound));
                    }
                }
            });
        });
    }
}
