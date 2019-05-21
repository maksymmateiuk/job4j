package ru.job4j.array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Array char tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] result = bubbleSort.sort(input);
        assertThat(result, is(expected));
    }
}