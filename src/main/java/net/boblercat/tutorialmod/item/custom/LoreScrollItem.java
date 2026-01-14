package net.boblercat.tutorialmod.item.custom;

import net.boblercat.tutorialmod.utill.LoreEntry;
import net.boblercat.tutorialmod.utill.LoreManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LoreScrollItem extends Item {
    public LoreScrollItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient) {
            // Get the Custom Object
            LoreEntry entry = LoreManager.getRandomLore();

            // Access the Object's fields
            user.sendMessage(Text.of("§7[Author: " + entry.getAuthor() + "]"));
            user.sendMessage(Text.of("§6" + entry.getText()));
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}