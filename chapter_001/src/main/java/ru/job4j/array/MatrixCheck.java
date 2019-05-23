package ru.job4j.array;

/**
 * Matrix check.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if ((data[0][0] != data[i][i]) || !(data[(data.length - 1) - i][i]
                    == data[i][(data.length - 1) - i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
