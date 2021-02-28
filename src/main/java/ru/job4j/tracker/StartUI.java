package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("Task #1");
        tracker.add(item);
        Item itemFound = tracker.findById(1);
        System.out.println("Looking for item with id = 1...");
        if (itemFound == null) {
            System.out.println("Not found");
        } else {
            System.out.println("We are found: " + itemFound.getName());
        }
    }
}