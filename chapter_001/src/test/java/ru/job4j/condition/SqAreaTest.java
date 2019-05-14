package ru.job4j.condition;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Sqarea tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SqAreaTest {

    @Test
    public void p4k1s1() {
        assertThat(SqArea.square(4, 1), is(1));
    }

    @Test
    public void p6k2s2() {
        assertThat(SqArea.square(6, 2), is(2));
    }
}