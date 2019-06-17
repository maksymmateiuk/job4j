package ru.job4j.array;

/**
 * Bubble sort.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {

    public int[] sort(int[] array) {
        int tmp;
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        return array;
    }
}
