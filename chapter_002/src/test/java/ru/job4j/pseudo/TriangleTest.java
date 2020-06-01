package ru.job4j.pseudo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Triangle tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
      Triangle triangle = new Triangle();
      assertThat(
            triangle.draw(),
            is(new StringBuilder()
                        .append("  +").append("\n")
                        .append(" +++").append("\n")
                        .append("+++++").append("\n")
                        .toString()));
    }
}