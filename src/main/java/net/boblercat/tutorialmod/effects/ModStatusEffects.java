package net.boblercat.tutorialmod.effects;

import net.boblercat.tutorialmod.TutorialMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect ANTIHEAL = registerEffect("antiheal",new AntiHealEffect());
    public static final StatusEffect DECAY = registerEffect("decay",new  DecayEffect());
    public static final StatusEffect JACKPOT = registerEffect("jackpot",new JackpotEffect(StatusEffectCategory.BENEFICIAL, 0x49ef00));


    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TutorialMod.MOD_ID, name), effect);
    }
    public static void registerModEffects(){
        TutorialMod.LOGGER.info("Registering Status Effects for " + TutorialMod.MOD_ID);
    }
}
