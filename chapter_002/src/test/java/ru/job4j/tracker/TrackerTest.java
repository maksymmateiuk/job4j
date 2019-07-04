package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tracker tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteFirstItemThenReturnTrueAndNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        boolean statusDeleting = tracker.delete(firstItem.getId());
        assertThat(statusDeleting, is(true));
        assertThat(tracker.findById(firstItem.getId()), is(Matchers.nullValue()));
    }

    @Test
    public void whenDeleteMiddleItemThenReturnTrueAndNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        boolean statusDeleting = tracker.delete(secondItem.getId());
        assertThat(statusDeleting, is(true));
        assertThat(tracker.findById(secondItem.getId()), is(Matchers.nullValue()));
    }

    @Test
    public void whenDeleteLastItemThenReturnTrueAndNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        boolean statusDeleting = tracker.delete(thirdItem.getId());
        assertThat(statusDeleting, is(true));
        assertThat(tracker.findById(thirdItem.getId()), is(Matchers.nullValue()));
    }

    @Test
    public void whenDeleteNotExistingItemThenReturnFalseAndNull() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item notExistingItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        boolean statusDeleting = tracker.delete(notExistingItem.getId());
        assertThat(statusDeleting, is(false));
        assertThat(tracker.findById(notExistingItem.getId()), is(Matchers.nullValue()));
    }

    @Test
    public void whenThreeItemsThenFindAllReturnThreeItems() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        Item[] expected = {firstItem, secondItem, thirdItem};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    @Test
    public void whenEmptyTrackerThenFindAllReturnNoItems() {
        Tracker tracker = new Tracker();
        Item[] expected = {};
        Item[] result = tracker.findAll();
        assertThat(result, is(expected));
    }

    @Test
    public void whenTrackerHasOneUniqueNameItemThenFindByNameReturnOneItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test2", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        Item[] expected = new Item[100];
        expected[0] = secondItem;
        Item[] result = tracker.findByName(secondItem.getName());
        assertThat(result, is(expected));
    }

    @Test
    public void whenTrackerHasThreeSameNameItemsThenFindByNameReturnThreeItems() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1", System.currentTimeMillis());
        Item secondItem = new Item("test1", "testDescription2", System.currentTimeMillis());
        Item thirdItem = new Item("test1", "testDescription3", System.currentTimeMillis());
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        Item[] expected = new Item[100];
        expected[0] = firstItem;
        expected[1] = secondItem;
        expected[2] = thirdItem;
        Item[] result = tracker.findByName(firstItem.getName());
        assertThat(result, is(expected));
    }
}