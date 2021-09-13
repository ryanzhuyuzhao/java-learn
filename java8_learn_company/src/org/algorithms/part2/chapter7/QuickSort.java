package org.algorithms.part2.chapter7;

import java.util.Arrays;

/**
 * 快速排序  最坏时间复杂度○(n²)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num = {12, 34, 343, 333, 11, 1, 32432, 432423432, 432423432};
        quickSort(num, 0 ,num.length - 1);
        Arrays.stream(num).forEach(System.out::println);
    }

    /**
     * 快速排序方法--升序排序
     * @param num
     * @param low
     * @param high
     */
    public static void quickSort(int[] num, int low, int high) {
        if (low < high) {
            int q = partition(num, low, high);
            quickSort(num, low, q - 1);
            quickSort(num, q + 1, high);
        }
    }

    /**
     * 快速排序中的分区
     * @param num
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] num, int low, int high) {
        int x = num[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (num[j] <= x) {//改变判断 小于x--升序排序  大于x--降序排序
                i++;
                int tmp = num[j];
                num[j] = num[i];
                num[i] = tmp;
            }
        }
        int tmp = num[high];
        num[high] = num[i + 1];
        num[i + 1] = tmp;
        return i + 1;
    }
}
