package com.alogrithm.learn.part1.datastructure.queue;

/**
 * @ClassName LoopQueue
 * @Description 循环队列
 * @Author Administrator
 * @Date 2021/8/22 0022 22:06
 * @Version 1.0
 */
public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity) {
        /**
         * 因为循环队列是否满的判断条件是(tail+1)%length==front,所以队列中有一个位置是故意空出来的，
         * 所以data数组的长度length=capacity+1
         */
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    //使用front与tail实现size
    public int getSize2() {
        if (tail > front) {
            return tail - front;
        }else if (tail < front) {
            return data.length - front + tail;
        }else {
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        //判断队列是否为空的条件：front==tail
        return front == tail;
    }

    //获取容量
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i =  (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("size():" + queue.getSize());
            System.out.println("size2():" + queue.getSize2());
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
