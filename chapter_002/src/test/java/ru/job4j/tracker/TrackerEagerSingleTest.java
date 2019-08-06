package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tracker eager singleton test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerEagerSingleTest {

    private TrackerEagerSingle tracker = TrackerEagerSingle.getInstance();

    @Test
    public void whenSingletonThenReturnTheSameObject() {
        TrackerEagerSingle tracker = TrackerEagerSingle.getInstance();
        assertThat(tracker, is(this.tracker));
    }
}