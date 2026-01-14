package net.boblercat.tutorialmod.utill;

import net.fabricmc.loader.api.FabricLoader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoreManager {
    private static final List<LoreEntry> LORE_LIST = new ArrayList<>();
    private static final File SAVE_FILE = FabricLoader.getInstance().getConfigDir().resolve("mod_lore.txt").toFile();

    public static void loadLore() {
        LORE_LIST.clear();
        if (!SAVE_FILE.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line back into an Object
                // Format assumed: Author::Text
                String[] parts = line.split("::", 2);
                if (parts.length == 2) {
                    // Create the object from file data
                    LORE_LIST.add(new LoreEntry(parts[1], parts[0]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addLore(LoreEntry entry) {
        LORE_LIST.add(entry);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE, true))) {
            writer.write(entry.toSaveString()); // Use the object's method
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LoreEntry getRandomLore() {
        if (LORE_LIST.isEmpty()) return new LoreEntry("The scroll is blank...", "System");
        return LORE_LIST.get(new Random().nextInt(LORE_LIST.size()));
    }
}