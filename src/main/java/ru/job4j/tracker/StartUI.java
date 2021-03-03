package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
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
                int id = input.askInt("Enter Item id you want to edit: ");
                String name = input.askStr("Enter new Item name you want to set: ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Item with id = " + id + " was successfully edited");
                } else {
                    System.out.println("Item with id = " + id + " was not found");
                }
            } else if  (select == 3) {
                System.out.println("=== Delete existing Item ====");
                int id = input.askInt("Enter Item id you want to delete: ");
                if (tracker.delete(id)) {
                    System.out.println("Item with id = " + id + " was successfully deleted");
                } else {
                    System.out.println("Item with id = " + id + " was not found");
                }
            } else if  (select == 4) {
                System.out.println("=== Find Item by Id ====");
                int id = input.askInt("Enter Item id you want to find: ");
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Item with id = " + id + " was not found");
                } else {
                    System.out.println(item);
                }
            } else if  (select == 5) {
                System.out.println("=== Find Item by name ====");
                String name = input.askStr("Enter Item name you want to find: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}