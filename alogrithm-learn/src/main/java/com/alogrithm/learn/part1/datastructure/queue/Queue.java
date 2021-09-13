package com.alogrithm.learn.part1.datastructure.queue;

/**
 * @ClassName Queue
 * @Description
 * @Author Administrator
 * @Date 2021/8/22 0022 21:12
 * @Version 1.0
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * @Author Ryan
     * @Description 向队列添加元素
     * @Date 21:13 2021/8/22 0022
     * @Param [e]
     * @return void
     */
    void enqueue(E e);

    /**
     * @Author Ryan
     * @Description 队列中删除一个元素
     * @Date 21:14 2021/8/22 0022
     * @Param []
     * @return E
     */
    E dequeue();

    /**
     * @Author Ryan
     * @Description 获取队首的元素不删除
     * @Date 21:14 2021/8/22 0022
     * @Param []
     * @return E
     */
    E getFront();


}
