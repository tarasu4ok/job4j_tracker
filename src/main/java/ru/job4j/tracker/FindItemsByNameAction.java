package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction{
    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== ============= ===");
        String name = input.askStr("Enter Item name you want to find: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Items with name = " + name + " were not found");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
        return true;
    }
}
