package ru.job4j.tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class SortByNameItemTest {

    private static final long TIME = 0L;

    @Test
    public void shouldSortByNameItem() {
        List<Item> items = Arrays.asList(
                new Item("test2", "testDescription2", TIME),
                new Item("test1", "testDescription1", TIME),
                new Item("test3", "testDescription3", TIME)
        );
        Collections.sort(items, new SortByNameItem());
        List<Item> expectedListItems = Arrays.asList(
                new Item("test1", "testDescription1", TIME),
                new Item("test2", "testDescription2", TIME),
                new Item("test3", "testDescription3", TIME)
        );
        assertThat(items, is(expectedListItems));
    }

    @Test
    public void shouldSortByNameItemInReverseOrder() {
        List<Item> items = Arrays.asList(
                new Item("test2", "testDescription2", TIME),
                new Item("test1", "testDescription1", TIME),
                new Item("test3", "testDescription3", TIME)
        );
        Collections.sort(items, new SortByNameItem().reversed());
        List<Item> expectedListItems = Arrays.asList(
                new Item("test3", "testDescription3", TIME),
                new Item("test2", "testDescription2", TIME),
                new Item("test1", "testDescription1", TIME)
        );
        assertThat(items, is(expectedListItems));
    }
}