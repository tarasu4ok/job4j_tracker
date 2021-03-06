package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit existing Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== ============= ===");
        int id = input.askInt("Enter Item id you want to edit: ");
        String name = input.askStr("Enter new Item name you want to set: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Item with id = " + id + " was successfully edited");
        } else {
            out.println("Item with id = " + id + " was not found");
        }
        return true;
    }
}
