package ru.job4j.condition;

/**
 * Multi Max.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class MultiMax {

    public int max(int first, int second, int third) {
        int result = first;
        if (!(first == second && second == third)) {
            int tmp = first > second ? first : second;
            result = tmp > third ? tmp : third;
        }
        return result;
    }
}
