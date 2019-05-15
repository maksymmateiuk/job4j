package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Factorial {

    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
