package net.boblercat.tutorialmod.effects;

import net.boblercat.tutorialmod.TutorialMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {
    public static final StatusEffect ANTIHEAL = new AntiHealEffect();
    public static final StatusEffect DECAY = new AntiHealEffect();


    private static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TutorialMod.MOD_ID, name), effect);
    }
    public static void registerModEffects(){
        TutorialMod.LOGGER.info("Registering Status Effects for " + TutorialMod.MOD_ID);
    }
}
