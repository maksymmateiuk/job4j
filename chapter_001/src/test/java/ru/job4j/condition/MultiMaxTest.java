package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Max tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MultiMaxTest {

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(5, 4, 2);
        assertThat(result, is(5));
    }

    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenAllTheSame() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 1, 1);
        assertThat(result, is(1));
    }
}