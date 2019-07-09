package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

/**
 * Start UI tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

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
}