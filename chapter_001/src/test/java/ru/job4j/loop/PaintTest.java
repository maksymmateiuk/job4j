package ru.job4j.loop;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;

import org.junit.Test;

/**
 * Paint tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PaintTest {
   @Test
   public void whenPyramid4Right() {
      Paint paint = new Paint();
      String rst = paint.rightTrl(4);
      assertThat(rst,
            is(
                  new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("^   ")
                        .add("^^  ")
                        .add("^^^ ")
                        .add("^^^^")
                        .toString()));
   }

   @Test
   public void whenPyramid4Left() {
      Paint paint = new Paint();
      String rst = paint.leftTrl(4);
      assertThat(rst,
            is(
                  new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                        .add("   ^")
                        .add("  ^^")
                        .add(" ^^^")
                        .add("^^^^")
                        .toString()));
   }

    @Test
    public void whenPyramidWithHeightThree() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^^^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }
}