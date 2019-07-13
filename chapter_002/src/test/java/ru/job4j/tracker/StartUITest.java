package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Start UI tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = "0. Add new Item\n" +
            "1. Show all items\n" +
            "2. Edit item\n" +
            "3. Delete item\n" +
            "4. Find item by id\n" +
            "5. Find items by name\n" +
            "6. Exit Program\n";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddItemThenTrackerHasItem() {
        Item item = new Item("name", "desc", System.currentTimeMillis());
        Input input = new StubInput(new String[] {"0", item.getName(), item.getDescription(), "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        Item itemResult = tracker.findByName(item.getName())[0];
        assertThat(item.getName(), is(itemResult.getName()));
    }

    @Test
    public void whenEditItemThenItemWasEdited() {
        Item item = new Item("name", "desc", System.currentTimeMillis());
        Tracker tracker = new Tracker();
        item = tracker.add(item);
        Item toEditItem = new Item("edited", "edited desc", System.currentTimeMillis());
        Input input = new StubInput(new String[] {"2", item.getId(), toEditItem.getName(), toEditItem.getDescription(), "6"});
        new StartUI(input, tracker).init();
        Item itemResult = tracker.findByName(toEditItem.getName())[0];
        assertThat(item.getId(), is(itemResult.getId()));
    }

    @Test
    public void whenDeleteItemThenItemDeleted() {
        Item item = new Item("name", "desc", System.currentTimeMillis());
        Tracker tracker = new Tracker();
        item = tracker.add(item);
        Input input = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item[] itemResult = tracker.findByName(item.getName());
        assertThat(itemResult, is(new Item[]{}));
    }

    @Test
    public void whenGetAllItemThenShowAllItems() {
        Item item1 = new Item("test1", "desc1", 1L);
        Item item2 = new Item("test2", "desc2", 2L);
        Input input = new StubInput(new String[]{"1", "6"});
        Tracker tracker = new Tracker();
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
            is(new StringBuilder()
                  .append(menu)
                  .append("-------------------------------------------------")
                  .append(System.lineSeparator())
                  .append("Id: " + item1.getId())
                  .append(System.lineSeparator())
                  .append("Name: " + item1.getName())
                  .append(System.lineSeparator())
                  .append("Description: " + item1.getDescription())
                  .append(System.lineSeparator())
                  .append("-------------------------------------------------")
                  .append(System.lineSeparator())
                  .append("-------------------------------------------------")
                  .append(System.lineSeparator())
                  .append("Id: " + item2.getId())
                  .append(System.lineSeparator())
                  .append("Name: " + item2.getName())
                  .append(System.lineSeparator())
                  .append("Description: " + item2.getDescription())
                  .append(System.lineSeparator())
                  .append("-------------------------------------------------")
                  .append(System.lineSeparator())
                  .append(menu)
                  .toString()));
    }

    @Test
    public void whenInvokeFindByIdThenThenPrintFoundItem() {
        Item item = new Item("test1", "desc1", 1L);
        Tracker tracker = new Tracker();
        item = tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("-------------------------------------------------")
                        .append(System.lineSeparator())
                        .append("Id: " + item.getId())
                        .append(System.lineSeparator())
                        .append("Name: " + item.getName())
                        .append(System.lineSeparator())
                        .append("Description: " + item.getDescription())
                        .append(System.lineSeparator())
                        .append("-------------------------------------------------")
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()));
    }

    @Test
    public void whenInvokeFindByNameThenThenPrintFoundItem() {
        Item item = new Item("test1", "desc1", 1L);
        Tracker tracker = new Tracker();
        item = tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("-------------------------------------------------")
                        .append(System.lineSeparator())
                        .append("Id: " + item.getId())
                        .append(System.lineSeparator())
                        .append("Name: " + item.getName())
                        .append(System.lineSeparator())
                        .append("Description: " + item.getDescription())
                        .append(System.lineSeparator())
                        .append("-------------------------------------------------")
                        .append(System.lineSeparator())
                        .append(menu)
                        .toString()));
    }

}