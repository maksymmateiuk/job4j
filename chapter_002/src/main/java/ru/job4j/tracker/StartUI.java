package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.tracker.actions.AddItem;
import ru.job4j.tracker.actions.DeleteItem;
import ru.job4j.tracker.actions.ExitProgram;
import ru.job4j.tracker.actions.FindItemById;
import ru.job4j.tracker.actions.FindItemsByName;
import ru.job4j.tracker.actions.ShowItems;
import ru.job4j.tracker.actions.UpdateItem;

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
    private boolean working = true;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    public void init() {
        MenuTracker menuTracker = new MenuTracker(this.input, this.tracker);
        menuTracker.addAction(new AddItem(0, "Add the new item."));
        menuTracker.addAction(new ShowItems(1, "Show all items."));
        menuTracker.addAction(new UpdateItem(2, "Edit item."));
        menuTracker.addAction(new DeleteItem(3, "Delete item."));
        menuTracker.addAction(new FindItemById(4, "Find item by id."));
        menuTracker.addAction(new FindItemsByName(5, "Find items by name."));
        menuTracker.addAction(new ExitProgram(6, "Exit Program.", this));
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menuTracker.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menuTracker.show();
            menuTracker.select(input.ask("Select: ", range));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }
}
