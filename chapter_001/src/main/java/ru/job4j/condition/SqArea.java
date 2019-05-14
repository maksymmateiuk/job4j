package ru.job4j.condition;

/**
 * SqArea.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class SqArea {

    /**
     * Calculate square
     * @param p perimeter
     * @param k coefficient
     * @return square
     */
    public static int square(int p, int k) {
        int height = p / (2 * k + 2);
        return height * height * k;
    }
}
