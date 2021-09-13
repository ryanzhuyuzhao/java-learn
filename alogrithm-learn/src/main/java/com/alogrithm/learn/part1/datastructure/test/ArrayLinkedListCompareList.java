package com.alogrithm.learn.part1.datastructure.test;

import com.alogrithm.learn.part1.datastructure.stack.ArrayStack;
import com.alogrithm.learn.part1.datastructure.stack.LinkedListStack;
import com.alogrithm.learn.part1.datastructure.stack.Stack;

import java.util.Random;

/**
 * @ClassName ArrayLinkedListCompareList
 * @Description
 * @Author Administrator
 * @Date 2021/8/23 0023 21:50
 * @Version 1.0
 */
public class ArrayLinkedListCompareList {

    //测试使用stack运行opCount个push和pop操作所需要的时间，单位秒
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / (1000 * 1000 * 1000.0);
    }

    public static void main(String[] args) {
        int optCount = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack,optCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, optCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        //其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }
}
