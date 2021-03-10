package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction{
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter Item id you want to find: ");
        Item item = tracker.findById(id);
        if (item == null) {
            out.println("Item with id = " + id + " was not found");
        } else {
            out.println(item);
        }
        return true;
    }
}
