package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Validate input tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {

    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidNumberOfMenuInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "1"}));
        input.ask("invalid", Collections.singletonList(1));
        assertThat(this.mem.toString(), is(String.format("Please enter validate data again.%n")));
    }

    @Test
    public void whenInvalidInputCharacter() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"98", "99"}));
        input.ask("98", Collections.singletonList(99));
        assertThat(this.mem.toString(), is(String.format("Please select key from menu.%n")));
    }
}