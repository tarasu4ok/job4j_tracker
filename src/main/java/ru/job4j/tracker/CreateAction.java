package ru.job4j.tracker;

public class CreateAction implements UserAction{
    @Override
    public String name() {
        return "Create a new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== ============= ===");
        String name = input.askStr("Enter Item's name you want to add: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
