package net.boblercat.tutorialmod.mixin;

import net.boblercat.tutorialmod.TutorialMod; // Import your main class
import net.boblercat.tutorialmod.effects.ModStatusEffects;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// This tells Fabric: "We are editing the LivingEntity code"
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    // Inject code at the HEAD (start) of the 'heal' method
    @Inject(method = "heal", at = @At("HEAD"), cancellable = true)
    private void preventHealing(float amount, CallbackInfo ci) {
        // Cast 'this' to LivingEntity so we can check effects
        LivingEntity entity = (LivingEntity) (Object) this;

        // Check if they have your Anti-Heal effect
        // CHANGE 'TutorialMod.ANTI_HEAL' to whatever you named your variable in the registry!
        if (entity.hasStatusEffect(ModStatusEffects.ANTIHEAL)) {
            // STOP the method right here. No healing happens.
            ci.cancel();
        }
    }
}