package com.alogrithm.learn.part1.datastructure.queue;

/**
 * @ClassName LoopQueue
 * @Description 循环队列
 * @Author Administrator
 * @Date 2021/8/22 0022 22:06
 * @Version 1.0
 */
public class LoopQueue2<E> implements Queue<E>{
    private E[] data;
    private int front,tail;
    private int size;

    public LoopQueue2(int capacity) {
        /**
         * 因为循环队列是否满的判断条件是(tail+1)%length==front,所以队列中有一个位置是故意空出来的，
         * 所以data数组的长度length=capacity+1
         */
        data = (E[])new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    //使用front与tail实现size
    public int getSize2() {
        if (tail > front) {
            return tail - front + 1;
        }else if (tail < front) {
            return data.length - front + tail + 1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        //判断队列是否为空的条件：front==tail
        return front == tail && size == 0;
    }

    //获取容量
    public int getCapacity() {
        return data.length;
    }

    @Override
    public void enqueue(E e) {
        if (tail% data.length == front && size == data.length) {
            resize(getCapacity() * 2);
        }
		data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
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
        int sum = 0;
        for (int i = front; i != tail ||(i == tail && sum != size); i =  (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail ) {
                res.append(",");
            }
            sum++;
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue2<Integer> queue = new LoopQueue2<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
