package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "Delete existing Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== ============= ===");
        int id = input.askInt("Enter Item id you want to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item with id = " + id + " was successfully deleted");
        } else {
            System.out.println("Item with id = " + id + " was not found");
        }
        return true;
    }
}
