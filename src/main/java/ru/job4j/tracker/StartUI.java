package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit existing Item ====");
        int id = input.askInt("Enter Item id you want to edit: ");
        String name = input.askStr("Enter new Item name you want to set: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Item with id = " + id + " was successfully edited");
        } else {
            System.out.println("Item with id = " + id + " was not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete existing Item ====");
        int id = input.askInt("Enter Item id you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item with id = " + id + " was successfully deleted");
        } else {
            System.out.println("Item with id = " + id + " was not found");
        }
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== All items in Tracker  ====");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.println(item);
        }
    }

    public static void findItemById(Input input, Tracker tracker){
        System.out.println("=== Find Item by Id ====");
        int id = input.askInt("Enter Item id you want to find: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item with id = " + id + " was not found");
        } else {
            System.out.println(item);
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.findAllItems(tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemById(input, tracker);
                    break;
                case 5:
                    StartUI.findItemsByName(input, tracker);
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choice! Choose right one!");
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