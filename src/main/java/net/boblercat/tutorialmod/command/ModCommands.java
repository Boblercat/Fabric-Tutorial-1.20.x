package net.boblercat.tutorialmod.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.boblercat.tutorialmod.command.AddLoreCommand;

public class ModCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            AddLoreCommand.register(dispatcher);
        });
    }
}