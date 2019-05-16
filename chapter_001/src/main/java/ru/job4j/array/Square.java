package ru.job4j.array;

/**
 * Square.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Square {

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int start = 1;
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(start, 2);
            start++;
        }
        return rst;
    }
}
