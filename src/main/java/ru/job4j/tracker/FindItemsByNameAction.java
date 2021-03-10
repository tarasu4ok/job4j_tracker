package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction{
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter Item name you want to find: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            out.println("Items with name = " + name + " were not found");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}
