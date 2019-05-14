package ru.job4j.converter;

/**
 * Converter.
 */
public class Converter {

    /**
     * Converter ruble to euro.
     * @param value integer
     * @return integer
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Converter ruble to dollar.
     * @param value integer
     * @return integer
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Converter euro to ruble.
     * @param value integer
     * @return integer
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Converter dollar to ruble.
     * @param value integer
     * @return integer
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}
