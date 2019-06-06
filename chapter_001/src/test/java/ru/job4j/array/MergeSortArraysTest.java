package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Merge sort arrays test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MergeSortArraysTest {

    @Test
    public void whenTwoSortedArraysThenResultIsThirdSortedArray() {
        MergeSortArrays arrays = new MergeSortArrays();
        int[] expected = {1, 2, 3, 4};
        int[] left = {1, 2};
        int[] right = {3, 4};

        int[] result = arrays.merge(left, right);
        assertThat(result, is(expected));
    }
}