package com.alogrithm.learn.part1.datastructure.stack;

/**
 * @ClassName Stack
 * @Description
 * @Author Administrator
 * @Date 2021/8/22 0022 16:47
 * @Version 1.0
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
