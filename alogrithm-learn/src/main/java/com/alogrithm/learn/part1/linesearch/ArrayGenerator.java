package com.alogrithm.learn.part1.linesearch;

import java.util.Random;

/**
 * @ClassName ArrayGenerator
 * @Description
 * @Author Administrator
 * @Date 2021/8/18 0018 22:21
 * @Version 1.0
 */
public class ArrayGenerator {

    private ArrayGenerator() {

    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
