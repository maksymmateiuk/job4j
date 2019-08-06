package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tracker lazy singleton test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerLazySingleTest {

    private TrackerLazySingle tracker = TrackerLazySingle.getInstance();

    @Test
    public void whenSingletonThenReturnTheSameObject() {
        TrackerLazySingle tracker = TrackerLazySingle.getInstance();
        assertThat(tracker, is(this.tracker));
    }
}