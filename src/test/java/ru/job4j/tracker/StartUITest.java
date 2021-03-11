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
                new String[] {"0", "Item name", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllItemsAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String expected = "";
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            expected += item + System.lineSeparator();
        }
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. All items in Tracker" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. All items in Tracker" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        expected +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. All items in Tracker" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "Item name", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindItemsByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String expected = "";
        Item[] itemsByName = tracker.findByName("Item name");
        for (Item item : itemsByName) {
            expected += item + System.lineSeparator();
        }
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by name" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by name" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        expected +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by name" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindItemByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String expected = tracker.findById(1).toString() + System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by Id" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by Id" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator() +
                        expected +
                        "Menu." + System.lineSeparator() +
                        "0. Create a new Item" + System.lineSeparator() +
                        "1. Find Item by Id" + System.lineSeparator() +
                        "2. Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"3", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit Program%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit Program%n"
                )
        ));
    }
}