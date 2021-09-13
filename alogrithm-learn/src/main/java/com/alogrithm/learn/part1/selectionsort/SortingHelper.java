package com.alogrithm.learn.part1.selectionsort;

import com.alogrithm.learn.part1.insertsort.InsertionSort;

/**
 * @ClassName SortingHelper
 * @Description 排序辅助类
 * @Author Administrator
 * @Date 2021/8/19 0019 20:30
 * @Version 1.0
 */
public class SortingHelper {
    private SortingHelper() {}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortedTest(String sortName,E[] arr) {
        long startTime = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sortReverse(arr);
        }else if (sortName.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        }else if (sortName.equals("InsertionSort2")) {
            InsertionSort.sort2(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / (1000 * 1000 * 1000.0);
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(time + " s");
    }
}
