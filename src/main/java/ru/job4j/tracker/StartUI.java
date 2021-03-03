package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items in Tracker  ====");
                Item[] allItems = tracker.findAll();
                for (Item item : allItems) {
                    System.out.println(item);
                }
            } else if  (select == 2) {
                System.out.println("=== Edit existing Item ====");
                System.out.print("Enter Item id you want to edit: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter new Item name you want to set: ");
                String name = scanner.nextLine();
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Item with id = " + id + " was successfully edited");
                } else {
                    System.out.println("Item with id = " + id + " was not found");
                }
            } else if  (select == 3) {
                System.out.println("=== Delete existing Item ====");
                System.out.print("Enter Item id you want to delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item with id = " + id + " was successfully deleted");
                } else {
                    System.out.println("Item with id = " + id + " was not found");
                }
            } else if  (select == 4) {
                System.out.println("=== Find Item by Id ====");
                System.out.print("Enter Item id you want to find: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Item with id = " + id + " was not found");
                } else {
                    System.out.println(item);
                }
            } else if  (select == 5) {
                System.out.println("=== Find Item by name ====");
                System.out.print("Enter Item name you want to find: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length == 0) {
                    System.out.println("Items with name = " + name + " were not found");
                } else {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("=== ============= ====");
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}