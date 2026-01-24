package net.boblercat.tutorialmod.client;

import net.boblercat.tutorialmod.effects.ModStatusEffects;
import net.boblercat.tutorialmod.sound.ModSounds;
import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

public class JackpotSoundInstance extends MovingSoundInstance {
    private final PlayerEntity owner;

    public JackpotSoundInstance(PlayerEntity owner){
        super(ModSounds.JACKPOT_MUSIC, SoundCategory.MUSIC, SoundInstance.createRandom());
        this.owner = owner;
        this.repeat = false;
        this.repeatDelay = 0;
        this.volume = 1.0f;
        this.pitch = 1.0f;

        this.x = owner.getX();
        this.y = owner.getY();
        this.z = owner.getZ();
    }

    @Override
    public void tick() {
        if(owner.isRemoved()||owner.isDead()){
            this.setDone();
            return;
        }
        boolean hasJackpot = false;
        if(this.owner.hasStatusEffect(ModStatusEffects.JACKPOT)){
            if(this.owner.getStatusEffect(ModStatusEffects.JACKPOT).getAmplifier()==0){
                hasJackpot = true;
            }
        }

        if(!hasJackpot){
            this.setDone();
            return;
        }
        this.x = owner.getX();
        this.y = owner.getY();
        this.z = owner.getZ();
    }
}
