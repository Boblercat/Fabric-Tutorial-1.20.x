package net.boblercat.tutorialmod.item.custom;

import net.boblercat.tutorialmod.item.MysteryItemRecipe;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class UnstableOrbItem extends Item {
    public UnstableOrbItem (Settings settings){
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // 1. Check if we are on the Server (logic doesn't run on client)
        // 2. Check if the entity holding it is a Player
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // Pick a random reward from your Recipe class
            Random random = new Random();
            int randomIndex = random.nextInt(MysteryItemRecipe.REWARD_POOL.size());
            Item rewardItem = MysteryItemRecipe.REWARD_POOL.get(randomIndex);

            // Create the new stack (preserving the count if you want, though usually it's 1)
            ItemStack rewardStack = new ItemStack(rewardItem, stack.getCount());

            // FORCE SWAP: Replace the item in the current slot with the reward
            player.getInventory().setStack(slot, rewardStack);

            // Optional: Play a "pop" or "magic" sound when it transforms
            world.playSound(
                    null,
                    player.getBlockPos(),
                    SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, // A nice magical tinkling sound
                    SoundCategory.PLAYERS,
                    1f,
                    1f
            );
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.unstable_orb.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
