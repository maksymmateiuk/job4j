package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Find item by id.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter item id: ");
        Item item = tracker.findById(id);
        System.out.println("-------------------------------------------------");
        System.out.println("Id: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        System.out.println("-------------------------------------------------");
    }
}
