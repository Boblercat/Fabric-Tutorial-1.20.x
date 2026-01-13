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

    // 1. CONSTANTS
    // We change the extension to .csv
    private static final Path FILE_PATH = FabricLoader.getInstance().getConfigDir().resolve("tutorialmod_rewards.csv");

    // 2. DATA STORAGE (The RAM List)
    private static final List<String> REWARD_POOL = new ArrayList<>();

    // 3. PUBLIC METHOD: Add an Item
    public static void addNewItem(Item item) {
        String id = Registries.ITEM.getId(item).toString();

        // Prevent duplicates in the list
        if (!REWARD_POOL.contains(id)) {
            REWARD_POOL.add(id);
            save(); // Save to CSV immediately
        }
    }

    // 4. PUBLIC METHOD: Check if item exists
    public static boolean contains(Item item) {
        String id = Registries.ITEM.getId(item).toString();
        return REWARD_POOL.contains(id);
    }

    // 5. INTERNAL METHOD: Save to CSV
    public static void save() {
        // "try-with-resources" block automatically closes the file when done
        try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {

            // Loop through every ID in our RAM list
            for (String id : REWARD_POOL) {
                writer.write(id);    // Write the item name (e.g., minecraft:diamond)
                writer.newLine();    // Press "Enter" to go to the next line
            }

        } catch (IOException e) {
            e.printStackTrace(); // Print error if saving fails
        }
    }

    // 6. INTERNAL METHOD: Load from CSV
    public static void load() {
        // Safety check: If file doesn't exist yet, stop.
        if (!Files.exists(FILE_PATH)) return;

        try (BufferedReader reader = Files.newBufferedReader(FILE_PATH)) {
            REWARD_POOL.clear(); // Clear old data before loading

            String line;
            // Read the file line-by-line until it is empty
            while ((line = reader.readLine()) != null) {
                // Ignore empty lines
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