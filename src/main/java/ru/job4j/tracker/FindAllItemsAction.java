package ru.job4j.tracker;

public class FindAllItemsAction implements UserAction{
    private final Output out;

    public FindAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "All items in Tracker";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        if (allItems.length != 0) {
            for (Item item : allItems) {
                out.println(item);
            }
        } else {
            out.println("No items found");
        }
        return true;
    }
}
