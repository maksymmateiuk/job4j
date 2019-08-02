package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * User action.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {

    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
