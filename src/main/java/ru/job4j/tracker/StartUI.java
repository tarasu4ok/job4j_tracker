package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Task #1"));
        tracker.add(new Item("Task #2"));
        tracker.add(new Item("Task #1"));
        System.out.println("========================");
        System.out.println("All tasks:");
        Item[] allItems = tracker.findAll();
        for (Item item: allItems) {
            System.out.println("id: " + item.getId() + ", name: " + item.getName());
        }
        Item itemFound = tracker.findById(1);
        System.out.println("========================");
        System.out.println("Looking for item with id = 1...");
        if (itemFound == null) {
            System.out.println("Not found");
        } else {
            System.out.println("We are found: " + itemFound.getName());
        }
        System.out.println("========================");
        System.out.println("Looking for item with name = " + '"' + "Task #1" + '"');
        Item[] itemsFoundByName = tracker.findByName("Task #1");
        for (Item itemFoundByName: itemsFoundByName) {
            System.out.println("id: " + itemFoundByName.getId() + ", name: " + itemFoundByName.getName());
        }
    }
}