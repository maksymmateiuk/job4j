package ru.job4j.pseudo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Square tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SquareTest {

    @Test
    public void whenDrawSquare() {
      Square square = new Square();
      assertThat(
            square.draw(),
            is(new StringBuilder()
                        .append("++++").append("\n")
                        .append("+  +").append("\n")
                        .append("+  +").append("\n")
                        .append("++++").append("\n")
                        .toString()));
    }
}