/*
package net.boblercat.tutorialmod.utill;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RewardDataManager {


    private static final Path FILE_PATH = FabricLoader.getInstance().getConfigDir().resolve("tutorialmod_rewards.csv");
    private static final List<String> REWARD_POOL = new ArrayList<>();
    public static void addNewItem(Item item) {
        String id = Registries.ITEM.getId(item).toString();


        if (!REWARD_POOL.contains(id)) {
            REWARD_POOL.add(id);
            save();
        }
    }

    public static boolean contains(Item item) {
        String id = Registries.ITEM.getId(item).toString();
        return REWARD_POOL.contains(id);
    }

    public static void save() {
        // "try-with-resources" block automatically closes the file when done
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {

            // Loop through every ID in our RAM list
            for (String id : REWARD_POOL) {
                writer.write(id);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void load() {

        if (!Files.exists(FILE_PATH)) return;

        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            REWARD_POOL.clear();

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    REWARD_POOL.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 */