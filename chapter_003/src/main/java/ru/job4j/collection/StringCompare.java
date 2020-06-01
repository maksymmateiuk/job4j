package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int lessLength = Math.min(left.length(), right.length());
        for (int i = 0; i < lessLength; i++) {
            int comparingInt = Character.compare(left.charAt(i), right.charAt(i));
            if (comparingInt != 0) {
                result = comparingInt;
                break;
            }
        }

        return result;
    }
}
