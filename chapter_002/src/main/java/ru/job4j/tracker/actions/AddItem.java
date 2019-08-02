package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Add item.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Adding new item --------------");
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDescription());
    }
}