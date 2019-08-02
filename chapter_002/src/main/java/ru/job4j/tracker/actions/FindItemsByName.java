package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Find item by name.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please, enter item name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println("-------------------------------------------------");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("-------------------------------------------------");
        }
    }
}
