package com.alogrithm.learn.part1.insertsort;

import com.alogrithm.learn.part1.linesearch.ArrayGenerator;
import com.alogrithm.learn.part1.selectionsort.SortingHelper;

import java.util.Arrays;

/**
 * @ClassName InsertionSort
 * @Description 插入排序
 * @Author Administrator
 * @Date 2021/8/19 0019 22:50
 * @Version 1.0
 */
public class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            /*for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }else {
                    break;
                }
            }*/

            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    //优化后的插入排序，将索引暂存起来，不用每次都交换
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //暂存索引所在的值
            E tmp = arr[i];
            int j;
            //将arr[i]插入到合适的位置
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j - 1] = arr[j];
            }
            arr[j] = tmp;
        }
    }

    public static <E> void swap(E[] arr,int i,int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int size : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(size, size);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);
            SortingHelper.sortedTest("InsertionSort", arr);
            SortingHelper.sortedTest("InsertionSort2", arr2);
        }
    }
}
