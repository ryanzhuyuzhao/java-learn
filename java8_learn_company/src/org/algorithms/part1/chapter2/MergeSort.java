package org.algorithms.part1.chapter2;

import java.util.Arrays;

/**
 * 合并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {2, 7, 8, 3, 1, 6, 9, 0, 5, 4};
        mergeSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(s -> System.out.print(s + "\t"));
    }

    public static int[] mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    public static void merge(int[] nums, int p, int q, int r) {//满足p≤q＜r
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] ll = new int[n1 + 1];
        int[] rr = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            ll[i] = nums[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rr[j] = nums[q + j + 1];
        }
        ll[n1] = Integer.MAX_VALUE;//哨兵值int的最大值
        rr[n2] = Integer.MAX_VALUE;//哨兵值int的最大值
        int i = 0;
        int j = 0;
        //r为整个数组的最后一个元素的下标，而不是数组的length，循环a.length=r+1次 
        for (int k = p; k < r + 1; k++) {
            if (ll[i] <= rr[j]) {
                nums[k] = ll[i];
                i++;
            }else {
                nums[k] = rr[j];
                j++;
            }
        }
    }
}
