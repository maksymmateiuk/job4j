package ru.job4j.tracker;

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
