package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Start UI tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUITest {

    @Test
    public void init() {
        Input input = new StubInput(new String[] {"create stub task"});
        new StartUI(input, new Tracker()).init();
    }
}