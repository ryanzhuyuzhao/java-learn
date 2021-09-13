package org.algorithms.part1.chapter2;

/**
 * 插入排序的时间复杂度位n2
 */
public class InsertAlgorithms {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,7,1,2,3};
        insertSort(arr);
        for (int n : arr) {
            System.out.print(n + "\t");
        }

        System.out.println();
        insertSortDesc(arr);
        for (int n : arr) {
            System.out.print(n + "\t");
        }
    }

    /**
     * 插入排序 升序排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int target;
        for (int i = 1; i < arr.length; i++) {
            target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = target;
        }
    }

    /**
     * 插入排序 升序排序
     * @param arr
     */
    public static void insertSortDesc(int[] arr) {
        int target;
        for (int i = 1; i < arr.length; i++) {
            target = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < target) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = target;
        }
    }

}
