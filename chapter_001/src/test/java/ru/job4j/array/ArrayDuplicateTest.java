package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class which testing delete duplicate in array.
 *
 * @author Maxim Mateuk
 * @version 1.0
 * @since 15.07.2017
 */

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array = {"Hi", "Super", "Hi", "Super", "World"};
        String[] expected = {"World", "Super", "Hi"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(array);
        assertThat(result, is(expected));
    }

}