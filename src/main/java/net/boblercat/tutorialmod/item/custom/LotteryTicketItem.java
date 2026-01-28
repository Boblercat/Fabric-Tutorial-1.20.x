package net.boblercat.tutorialmod.item.custom;

import net.boblercat.tutorialmod.TutorialMod;
import net.boblercat.tutorialmod.effects.ModStatusEffects;
import net.boblercat.tutorialmod.sound.ModSounds;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LotteryTicketItem extends Item {

    public LotteryTicketItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        StatusEffectInstance activeEffect = user.getStatusEffect(ModStatusEffects.JACKPOT);

        // 2. If they have it, AND it is the Jackpot version (Level 5 / Amp 4)
        if (activeEffect != null) {
            if (!world.isClient) {
                user.sendMessage(Text.of("§c§lYou already hit Jackpot! Save your tickets."), true);
            }

            return TypedActionResult.fail(stack);
        }
        if(!world.isClient){
            int count = stack.getCount();
            int reduction =((count-1)*237)/(63);
            int currentOdds = 239 - reduction;
            if(currentOdds<2) currentOdds =2;
            int chance = world.random.nextInt(currentOdds);

            if (chance == 0){
                user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.JACKPOT,5020,0));
                if (world instanceof ServerWorld serverWorld) {
                    // 1. Randomly pick a song
                    SoundEvent selectedSound;
                    if (world.random.nextBoolean()) {
                        selectedSound = ModSounds.JACKPOT_MUSIC; // Song 1
                    } else {
                        selectedSound = ModSounds.JACKPOT_MUSIC_2; // Song 2 (Make sure you registered this!)
                    }

                    // 2. Create Packet
                    PacketByteBuf buf = PacketByteBufs.create();
                    buf.writeInt(user.getId());

                    // 3. Write the ID of the chosen sound so the client knows what to play
                    buf.writeIdentifier(selectedSound.getId());

                    // 4. Send to everyone
                    for (ServerPlayerEntity player : serverWorld.getPlayers()) {
                        ServerPlayNetworking.send(player, TutorialMod.JACKPOT_PACKET_ID, buf);
                    }

                }
                user.sendMessage(Text.of("§aSUCCESS! JACKPOT!!!"),true);
                if (count >1) {
                    int save = world.random.nextInt(2);
                    if (save != 0){
                        stack.decrement(count);
                    } else{
                       stack.setCount(64);
                    }

                }
            }
            else{
                user.sendMessage(Text.of("§4Better luck next time..."),true);
                stack.decrement(1);
            }
        }
        return TypedActionResult.success(stack);
    }
}
