package ru.job4j.tracker;

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
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.fillActions();
        int key;
        do {
            menuTracker.show();
            key = Integer.parseInt(input.ask("Select: "));
            menuTracker.select(key);
        } while (key != 6);
    }
}
