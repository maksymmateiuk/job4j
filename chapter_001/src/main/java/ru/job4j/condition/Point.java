package ru.job4j.condition;

/**
 * Point.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Point {

    /**
     * Calculate distance.
     * @param x1 integer
     * @param y1 integer
     * @param x2 integer
     * @param y2 integer
     * @return distance
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow((x2 - x1), 2);
        double second = Math.pow((y2 - y1), 2);
        return Math.sqrt(first + second);
    }
}
