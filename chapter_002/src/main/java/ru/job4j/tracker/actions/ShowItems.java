package ru.job4j.tracker.actions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * Show items.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println("-------------------------------------------------");
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            System.out.println("-------------------------------------------------");
        }
    }
}
