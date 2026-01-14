package net.boblercat.tutorialmod.utill;

import java.util.Date;

public class LoreEntry {
    private String text;
    private String author;
    private String date;


    public LoreEntry(String text, String author) {
        this.text = text;
        this.author = author;
        this.date = new Date().toString(); // Auto-generates current time
    }

    public String getText() { return text; }
    public String getAuthor() { return author; }
    public String getDate() { return date; }

    // Helper method to turn this object into a String for saving to file
    public String toSaveString() {
        return author + "::" + text;
    }
}