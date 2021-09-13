package org.algorithms.part1.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中最大子数组
 */
public class FindMaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-1231, -312321, -12, -1, -11, -33};
        /*Map<String, Integer> map = findMaxCrossingSubArray(nums, 0, nums.length / 2 - 1, nums.length - 1);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });*/
        Map<String, Integer> map = findMaximumSubArray(nums, 0, nums.length - 1);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    /**
     * 求解跨越中间点的最大子数组
     * @param nums  数组
     * @param low
     * @param mid   中间点
     * @param high
     * @return
     */
    public static Map<String, Integer> findMaxCrossingSubArray(int[] nums, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + nums[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int sums = 0;
        int maxRight = 0;
        for (int j = mid + 1; j <= high; j++) {
            sums = sums + nums[j];
            if (sums > rightSum) {
                rightSum = sums;
                maxRight = j;
            }
        }
        Map<String, Integer> result = new HashMap<>(4);
        result.put("maxLeft",maxLeft);
        result.put("maxRight",maxRight);
        result.put("sum",rightSum + leftSum);
        return result;
    }

    /**
     * 求解数组的最大子数组
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public static Map<String, Integer> findMaximumSubArray(int[] nums, int low, int high) {
        Map<String, Integer> result = new HashMap<>(3);
        int start = 0;
        int end = 0;
        if (low == high) {//最小单位，分治到只有一个元素
            result.put("start",low);
            result.put("end",high);
            result.put("sum",nums[low]);
            return result;
        }else {
            int mid = (low + high) / 2;
            Map<String, Integer> leftMap = findMaximumSubArray(nums, low, mid);//求解左边最大子数组
            int leftLow = leftMap.get("start");
            int leftHigh = leftMap.get("end");
            int leftSum = leftMap.get("sum");
            Map<String, Integer> rightMap = findMaximumSubArray(nums, mid + 1,high);//求解右边最大子数组
            int rightLow = rightMap.get("start");
            int rightHigh = rightMap.get("end");
            int rightSum = rightMap.get("sum");
            Map<String, Integer> crossMap = findMaxCrossingSubArray(nums, low, mid, high);//求解跨中点最大子数组
            int crossLow = crossMap.get("maxLeft");
            int crossHigh = crossMap.get("maxRight");
            int crossSum = crossMap.get("sum");
            if (leftSum >= rightSum && leftSum >= crossSum) {
                result.put("start",leftLow);
                result.put("end",leftHigh);
                result.put("sum",leftSum);
                return result;
            }else if (rightSum >= leftSum && rightSum >= crossSum) {
                result.put("start",rightLow);
                result.put("end",rightHigh);
                result.put("sum",rightSum);
                return result;
            }else {
                result.put("start",crossLow);
                result.put("end",crossHigh);
                result.put("sum",crossSum);
                return result;
            }
        }
    }
}
