package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Start UI.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }

    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menuTracker.getActionsLength(); i++) {
            range.add(i);
        }
        int key;
        do {
            menuTracker.show();
            key = menuTracker.select(input.ask("Select: ", range));
        } while (key != 6);
    }
}
