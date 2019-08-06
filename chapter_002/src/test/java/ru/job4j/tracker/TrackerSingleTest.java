package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tracker singleton test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleTest {

    private TrackerSingle tracker = TrackerSingle.INSTANSE;

    @Test
    public void whenSingletonThenReturnTheSameObject() {
        TrackerSingle tracker = TrackerSingle.INSTANSE;
        assertThat(tracker, is(this.tracker));
    }
}