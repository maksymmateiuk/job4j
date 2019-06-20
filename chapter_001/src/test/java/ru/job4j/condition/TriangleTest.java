package ru.job4j.condition;

import org.hamcrest.number.IsCloseTo;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Triangle tests.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаем объект треугольник.
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 2), new Point(2, 0));
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, IsCloseTo.closeTo(expected, 0.1));
    }
}