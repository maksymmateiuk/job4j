package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getId().equals(id)) {
                    item.setId(id);
                    items.set(i, item);
                    result = true;
                    break;
                }
            }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) != null && items.get(i).getId().equals(id)) {
                    items.remove(i);
                    result = true;
                    break;
                }
            }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getName().equals(key)) {
                result.add(items.get(i));
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
