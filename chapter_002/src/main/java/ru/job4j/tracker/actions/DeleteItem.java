package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

/**
 * Delete item.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------ Deleting item ------");
        String id = input.ask("Please, enter item id: ");
        if (tracker.delete(id)) {
            System.out.println("------ Item deleted ------");
        } else {
            System.out.println("------ Item not found ------");
        }
    }
}
