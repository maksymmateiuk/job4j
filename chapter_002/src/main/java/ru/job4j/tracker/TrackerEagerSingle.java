package ru.job4j.tracker;

/**
 * Eager single Tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerEagerSingle {
    private static final TrackerEagerSingle INSTANCE = new TrackerEagerSingle();

    private TrackerEagerSingle() {

    }

    public static TrackerEagerSingle getInstance() {
        return INSTANCE;
    }
}
