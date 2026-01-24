package net.boblercat.tutorialmod;

import net.boblercat.tutorialmod.block.ModBlocks;
import net.boblercat.tutorialmod.client.JackpotSoundInstance;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerEntity;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYNITE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZYNITE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        ClientPlayNetworking.registerGlobalReceiver(TutorialMod.JACKPOT_PACKET_ID, (client, handler, buf, responseSender) -> {
            // Read the ID of the player who won (sent from server)
            int entityId = buf.readInt();

            client.execute(() -> {
                // Find that player in the client's world
                if (client.world != null) {
                    var entity = client.world.getEntityById(entityId);

                    if (entity instanceof PlayerEntity player) {
                        // START THE MOVING SOUND
                        client.getSoundManager().play(new JackpotSoundInstance(player));
                    }
                }
            });
        });
    }
}
