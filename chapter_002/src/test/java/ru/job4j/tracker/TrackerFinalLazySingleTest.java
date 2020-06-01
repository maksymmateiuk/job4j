package ru.job4j.tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tracker final lazy singleton test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerFinalLazySingleTest {

    private TrackerFinalLazySingle tracker = TrackerFinalLazySingle.getInstance();

    @Test
    public void whenSingletonThenReturnTheSameObject() {
        TrackerFinalLazySingle tracker = TrackerFinalLazySingle.getInstance();
        assertThat(tracker, is(this.tracker));
    }
}