package ru.job4j.tracker;

/**
 * Final lazy single Tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerFinalLazySingle {
    private TrackerFinalLazySingle() {

    }

    public static TrackerFinalLazySingle getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerFinalLazySingle INSTANCE = new TrackerFinalLazySingle();
    }
}
