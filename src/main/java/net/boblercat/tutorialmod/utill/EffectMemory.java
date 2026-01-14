package net.boblercat.tutorialmod.utill;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import java.util.Collection;
import java.util.Iterator;

public class EffectMemory {
    // RUBRIC: Standard Array (Fixed size of 3)
    private final StatusEffectInstance[] storedEffects = new StatusEffectInstance[3];

    // Method to ABSORB effects from the player
    public void absorbEffects(LivingEntity player) {
        Collection<StatusEffectInstance> currentEffects = player.getStatusEffects();
        Iterator<StatusEffectInstance> iterator = currentEffects.iterator();

        int i = 0;

        // RUBRIC: While Loop
        // Fills the array until it's full or we run out of effects
        while (i < storedEffects.length && iterator.hasNext()) {
            StatusEffectInstance effect = iterator.next();

            // Store a copy of the effect
            storedEffects[i] = new StatusEffectInstance(effect);

            i++;
        }

        // Remove them from the player after storing (optional, creates "Steal" effect)
        player.clearStatusEffects();
    }

    // Method to RELEASE effects back to the player
    public void releaseEffects(LivingEntity player) {
        int i = 0;

        // RUBRIC: Another While Loop (iterating the array)
        while (i < storedEffects.length) {
            // Check if this slot has an effect
            if (storedEffects[i] != null) {
                // Apply it to the player
                player.addStatusEffect(new StatusEffectInstance(storedEffects[i]));

                // Clear the slot (set to null) so it can be used again
                storedEffects[i] = null;
            }
            i++;
        }
    }

    // Helper to check if empty (for chat messages)
    public boolean isEmpty() {
        return storedEffects[0] == null;
    }
}