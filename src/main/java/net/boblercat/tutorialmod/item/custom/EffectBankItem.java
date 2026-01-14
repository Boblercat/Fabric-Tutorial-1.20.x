package net.boblercat.tutorialmod.item.custom;

import net.boblercat.tutorialmod.utill.EffectMemory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EffectBankItem extends Item {

    // OOC: Instantiating your custom object
    private static final EffectMemory MEMORY = new EffectMemory();

    public EffectBankItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {

            // ACTION 1: SNEAKING = STORE (Absorb)
            if (user.isSneaking()) {
                if (user.getStatusEffects().isEmpty()) {
                    user.sendMessage(Text.of("§cYou have no effects to store!"), true);
                } else {
                    MEMORY.absorbEffects(user);
                    user.sendMessage(Text.of("§aEffects sucked into the bank!"), true);
                }
            }
            // ACTION 2: STANDING = RELEASE (Apply)
            else {
                if (MEMORY.isEmpty()) {
                    user.sendMessage(Text.of("§cThe bank is empty."), true);
                } else {
                    MEMORY.releaseEffects(user);
                    user.sendMessage(Text.of("§eEffects restored!"), true);
                }
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}