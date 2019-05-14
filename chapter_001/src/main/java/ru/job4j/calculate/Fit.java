package ru.job4j.calculate;

/**
 * Fit calculator.
 *
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Fit {

    /**
     * Perfect weight for man.
     * @param height height.
     * @return perfect weight.
     */
    public double manWeight(double height) {
        return (height - 100D) * 1.15;
    }

    /**
     * Perfect weight for woman.
     * @param height height.
     * @return perfect weight.
     */
    public double womanWeight(double height) {
        return (height - 110D) * 1.15;
    }
}
