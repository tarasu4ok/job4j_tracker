package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction{
    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== ============= ===");
        int id = input.askInt("Enter Item id you want to find: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item with id = " + id + " was not found");
        } else {
            System.out.println(item);
        }
        return true;
    }
}