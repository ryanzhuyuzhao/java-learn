package com.alogrithm.learn.part1.selectionsort;


import com.alogrithm.learn.part1.linesearch.ArrayGenerator;

/**
 * @ClassName SelectionSort
 * @Description 选择排序
 * @Author Administrator
 * @Date 2021/8/19 0019 19:48
 * @Version 1.0
 */
public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for(int i = 0;i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[maxIndex].compareTo(arr[j]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr,i,maxIndex);
        }
    }

    public static <E extends Comparable<E>> void sortReverse(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr,i,maxIndex);
        }

    }

    public static <E> void swap(E[] arr,int i,int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        /*Integer[] arr = {6,4,2,3,1,5};
        SelectionSort.sort(arr);
        for (Integer e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

        Student[] students = {new Student("Ryan",100),
                            new Student("Natsu",90),
                            new Student("Loucai",80)
        };
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.print(student + " ");
        }
        System.out.println();*/
        int[] dataSize = {10000, 100000};
        for (int size : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(size, size);
            SortingHelper.sortedTest("SelectionSort", arr);
        }
    }
}
