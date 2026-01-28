package net.boblercat.tutorialmod.effects;

import net.boblercat.tutorialmod.sound.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;

public class JackpotEffect extends StatusEffect {
    public JackpotEffect(StatusEffectCategory category, int color) {
        super(category, color);

        // COMMAND: Add 40 HP (20 Hearts) while this effect is active
        this.addAttributeModifier(
                EntityAttributes.GENERIC_MAX_HEALTH, // 1. What are we changing?
                "7A2F5E3B-9C1D-4E8F-0A6B-2C5D8E2F1F6D", // 2. Unique ID (Must be random & unique)
                24.0, //
                EntityAttributeModifier.Operation.ADDITION // 4. Math (Add flat amount)
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }



    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.age % 3 == 0) {
            entity.heal(3.75f);
        }
        if(entity.getWorld() instanceof ServerWorld serverWorld){
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();

            serverWorld.spawnParticles(ParticleTypes.TOTEM_OF_UNDYING, x, y+1, z, 15, 0.37, 0.37, 0.37, 0.5);
        }

        if(amplifier == 0){
            if (!entity.getWorld().isClient && entity instanceof PlayerEntity player){
                StatusEffectInstance effect = player.getStatusEffect(ModStatusEffects.JACKPOT);

                if(effect != null){
                    int time = effect.getDuration();
                    if(time == 5018){
                        player.getServer().getPlayerManager().broadcast(Text.of("§6In other words..."),false);
                    } else if (time == 4980) {
                        player.getServer().getPlayerManager().broadcast(Text.of("§6For the next 4 minutes and 11 seconds following a jackpot"),false);
                    } else if (time == 4940) {
                        player.getServer().getPlayerManager().broadcast(Text.of(player.getName().getString() + " §6Is effectively Immortal."),false);
                    }
                }
            }
        }
    }
}

