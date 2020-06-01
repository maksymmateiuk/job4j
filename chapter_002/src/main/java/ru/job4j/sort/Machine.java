package ru.job4j.sort;

import java.util.Arrays;

public class Machine {

    private int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int change = money - price;
        for (int i = 0; i < coins.length; i++) {
            while (change - coins[i] >= 0) {
                rsl[size] = coins[i];
                size++;
                change -= coins[i];
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
