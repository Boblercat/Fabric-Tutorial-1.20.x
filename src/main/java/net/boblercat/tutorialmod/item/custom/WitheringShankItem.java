package net.boblercat.tutorialmod.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class WitheringShankItem extends Item {

    public WitheringShankItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Withering(target);
        stack.damage(1,attacker,e->e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    private void Withering(LivingEntity target) {
        if(target.hasStatusEffect(StatusEffects.WITHER)){
            StatusEffectInstance witherEffect = target.getStatusEffect(StatusEffects.WITHER);
            int witherLevel = witherEffect.getAmplifier();
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,400,witherLevel+1));
        }else{
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,400,0));
        }
    }
}
