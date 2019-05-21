package ru.job4j.array;

/**
 * Check array.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {

    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i]) {
                result = data[i];
            } else {
                result = data[i];
            }
        }
        return result;
    }
}
