package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubThreeMinusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.subsctract(3D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleTwoToFourThenEight()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 4D);
        double expected = 8D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivideTenByTwoThenFive()  {
        Calculator calc = new Calculator();
        double result = calc.divide(10D, 2D);
        double expected = 5D;
        assertThat(result, is(expected));
    }

}
