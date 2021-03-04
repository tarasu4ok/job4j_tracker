package ru.job4j.tracker;

public class FindAllItemsAction implements UserAction{
    @Override
    public String name() {
        return "All items in Tracker";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== ============= ===");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.println(item);
        }
        return true;
    }
}
