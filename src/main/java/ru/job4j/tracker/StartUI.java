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

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("=== ============= ===");
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new FindAllItemsAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemsByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}