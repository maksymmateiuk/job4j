package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.tracker.actions.UserAction;

/**
 * Menu tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void addAction(UserAction action) {
        this.actions.add(action);
    }

    public int getActionsLength() {
        return actions.size();
    }

    public int select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
        return key;
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
