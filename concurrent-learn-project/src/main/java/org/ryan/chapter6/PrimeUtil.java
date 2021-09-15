package org.ryan.chapter6;

import java.util.stream.IntStream;

/**
 * @ClassName PrimeUtil
 * @Description
 * @Author Administrator
 * @Date 2021/7/27 0027 20:57
 * @Version 1.0
 */
public class PrimeUtil {
    public static boolean isPrime(int number) {
        int tmp = number;
        if (tmp < 2) {
            return false;
        }
        for (int i = 2;Math.sqrt(tmp) >= i;i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long count = IntStream.range(1,10000000).filter(PrimeUtil::isPrime).count();
        long endTime = System.currentTimeMillis();
        System.out.println("consume time:" + (endTime - startTime));
        long startTimeP = System.currentTimeMillis();
        long countP = IntStream.range(1,10000000).parallel().filter(PrimeUtil::isPrime).count();
        long endTimep = System.currentTimeMillis();
        System.out.println("consume time parallel:" + (endTimep - startTimeP));
    }
}
