package net.boblercat.tutorialmod.utill;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import java.util.Collection;
import java.util.Iterator;

public class EffectMemory {
    // Fixed size of 3
    private final StatusEffectInstance[] storedEffects = new StatusEffectInstance[3];


    public boolean isFull() {
        int i = 0;
        // WHILE LOOP to check for empty spots
        while (i < storedEffects.length) {
            if (storedEffects[i] == null) {
                return false; // Found an empty spot, so it's NOT full
            }
            i++;
        }
        return true; // Checked all slots and found no nulls
    }


    public boolean absorbEffects(LivingEntity player) {
        // 1. Check if full immediately
        if (isFull()) {
            return false;
        }

        Collection<StatusEffectInstance> currentEffects = player.getStatusEffects();
        Iterator<StatusEffectInstance> iterator = currentEffects.iterator();


        while (iterator.hasNext()) {
            StatusEffectInstance effect = iterator.next();


            int i = 0;
            boolean stored = false;
            while (i < storedEffects.length) {
                if (storedEffects[i] == null) {
                    storedEffects[i] = new StatusEffectInstance(effect);
                    stored = true;
                    break;
                }
                i++;
            }

            if (!stored) {
                break;
            }
        }

        player.clearStatusEffects();
        return true;
    }

    public void releaseEffects(LivingEntity player) {
        int i = 0;
        while (i < storedEffects.length) {
            if (storedEffects[i] != null) {
                player.addStatusEffect(new StatusEffectInstance(storedEffects[i]));
                storedEffects[i] = null;
            }
            i++;
        }
    }

    public boolean isEmpty() {
        // Check if index 0 is empty (simple check)
        return storedEffects[0] == null && storedEffects[1] == null && storedEffects[2] == null;
    }
}