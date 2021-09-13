package com.alogrithm.learn.part1.linesearch;

import java.util.Arrays;

/**
 * @ClassName LineSearch 线性查找
 * @Description
 * @Author Administrator
 * @Date 2021/8/18 0018 20:14
 * @Version 1.0
 */
public class LineSearch {

    private LineSearch() {}

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*Integer[] data1 = {1,2,3,4,5,6,34};
        System.out.println(LineSearch.search(data1,1));
        System.out.println(LineSearch.search(data1,666));
        Student[] students = {new Student("Lily"),new Student("Ryan"),new Student("Yvone")};
        System.out.println(LineSearch.search(students,new Student("Ryan")));*/

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LineSearch.search(data,n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / (1000 * 1000 * 1000.0);
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
            
        }
    }
}
