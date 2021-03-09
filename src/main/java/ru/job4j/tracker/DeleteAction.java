package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete existing Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== ============= ===");
        int id = input.askInt("Enter Item id you want to delete: ");
        if (tracker.delete(id)) {
            out.println("Item with id = " + id + " was successfully deleted");
        } else {
            out.println("Item with id = " + id + " was not found");
        }
        return true;
    }
}
