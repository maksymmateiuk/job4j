package ru.job4j.tracker;

/**
 * Lazy single Tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerLazySingle {
    private static TrackerLazySingle instance;

    private TrackerLazySingle() {

    }

    public static TrackerLazySingle getInstance() {
        if (instance == null) {
            instance = new TrackerLazySingle();
        }
        return instance;
    }
}
