package ru.job4j.condition;

/**
 * Max.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Max {

    public int max(int first, int second) {
        int result = first;
        if (first != second) {
            result = first > second ? first : second;
        }

        return result;
    }
}
