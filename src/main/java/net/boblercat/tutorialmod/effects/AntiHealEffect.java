package net.boblercat.tutorialmod.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AntiHealEffect extends StatusEffect {
    public AntiHealEffect(){
        super(StatusEffectCategory.HARMFUL, 0xC86B85);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
