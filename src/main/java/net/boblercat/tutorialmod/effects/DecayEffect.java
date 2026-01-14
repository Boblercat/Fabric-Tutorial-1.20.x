package net.boblercat.tutorialmod.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class DecayEffect extends StatusEffect {

    public DecayEffect() {
        super(StatusEffectCategory.HARMFUL, 0x98D982);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(entity.getDamageSources().magic(), 1.5f * (amplifier + 1));
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}