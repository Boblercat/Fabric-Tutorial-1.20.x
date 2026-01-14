package net.boblercat.tutorialmod.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.boblercat.tutorialmod.utill.LoreEntry; // Import your object!
import net.boblercat.tutorialmod.utill.LoreManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class AddLoreCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("addlore")
                .then(CommandManager.argument("text", StringArgumentType.greedyString())
                        .executes(context -> {
                            String input = StringArgumentType.getString(context, "text");
                            String playerName = context.getSource().getName();

                            // RUBRIC: Instantiating your Custom Object
                            LoreEntry newEntry = new LoreEntry(input, playerName);

                            // Passing the object to the manager
                            LoreManager.addLore(newEntry);

                            context.getSource().sendFeedback(() -> Text.of("Lore added!"), false);
                            return 1;
                        })));
    }
}