package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    items[i] = item;
                    result = true;
                    break;
                }
            }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
            for (int i = 0; i < position; i++) {
                if (items[i] != null && items[i].getId().equals(id)) {
                    copyArray(++i);
                    result = true;
                    items[position] = null;
                    position--;
                    break;
                }
            }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int position = 0;
        for (int i = 0; i < this.position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[position++] = items[i];
            }
        }
        result = Arrays.copyOf(result, position);
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    private void copyArray(int index) {
        System.arraycopy(items, index, items, index - 1, items.length - index);
    }
}
