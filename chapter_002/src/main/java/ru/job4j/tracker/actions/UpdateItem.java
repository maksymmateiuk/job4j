package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Update item.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------ Editing item ------");
        String id = input.ask("Please, enter item id :");
        String name = input.ask("Please, enter new item's name :");
        String desc = input.ask("Please, enter new item's description :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            System.out.println("------ Items saved ------");
        } else {
            System.out.println("------ Item not found ------");
        }
    }
}
