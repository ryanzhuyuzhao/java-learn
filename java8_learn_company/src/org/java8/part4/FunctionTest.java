package org.java8.part4;

import java.util.stream.LongStream;

public class FunctionTest {

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        System.out.println(factorialIterative(10));
        System.out.println(System.nanoTime() - t1);
        long t2 = System.nanoTime();
        System.out.println(factorialRecursive(10));
        System.out.println(System.nanoTime() - t2);
        long t3 = System.nanoTime();
        System.out.println(factorialStreams(10));
        System.out.println(System.nanoTime() - t3);
    }

    /**
     * 迭代式的阶乘计算
     * @param n
     * @return
     */
    public static int factorialIterative(int n) {
        int r = 1;
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    /**
     * 递归式的阶乘
     * @param n
     * @return
     */
    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    /**
     * 基于Stream的阶乘
     * @param n
     * @return
     */
    public static long factorialStreams(long n) {
        return LongStream.rangeClosed(1,n)
                .reduce(1,(long a, long b) -> a * b);
    }
}
