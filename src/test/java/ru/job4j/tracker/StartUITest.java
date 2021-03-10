package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Task#1"));
        tracker.add(new Item("Task#2"));
        UserAction action = new FindAllItemsAction(output);
        action.execute(in, tracker);
        String expected = "";
        Item[] allItems = tracker.findAll();
        if (allItems.length != 0) {
            for (Item item : allItems) {
                expected += item + System.lineSeparator();
            }
        } else {
            expected = "No items found";
        }
        assertThat(output.toString(), is(expected));
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        String name = "Task#1";
        Input in = new StubInput(
                new String[] {name}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Task#1"));
        tracker.add(new Item("Task#2"));
        tracker.add(new Item("Task#1"));
        UserAction action = new FindItemsByNameAction(output);
        action.execute(in, tracker);
        String expected = "";
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            expected = "Items with name = " + name + " were not found";
        } else {
            for (Item item : items) {
                expected += item + System.lineSeparator();
            }
        }
        assertThat(output.toString(), is(expected));
    }

    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Task#1"));
        Item searchItem = new Item("Task#3");
        tracker.add(searchItem);
        int id = searchItem.getId();
        tracker.add(new Item("Task#2"));
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {String.valueOf(id)}
        );
        UserAction action = new FindItemByIdAction(output);
        action.execute(in, tracker);
        String expected = "";
        Item item = tracker.findById(id);
        if (item == null) {
            expected = "Items with id = " + id + " were not found";
        } else {
            expected += item + System.lineSeparator();
        }
        assertThat(output.toString(), is(expected));
    }
}