package com.alogrithm.learn.part1.datastructure.array;

/**
 * @ClassName Array
 * @Description
 * @Author Administrator
 * @Date 2021/8/21 0021 22:24
 * @Version 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;


    //构造函数，传入数组容量capacity构造Array
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参数构造函数默认capacity=10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组的头添加一个元素
    public void addFirst(E e) {
        add(0,e);
    }

    //向数组的末尾添加一个元素
    public void addLast(E e) {
        add(size,e);
    }

    //在第index个位置插入一个新元素e
    public void add(int index,E e) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //获取index位置的值
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    //返回数组第一个元素
    public E getFirst() {
        return get(0);
    }

    //返回数组最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //更新index位置的值
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E remove = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if (size == data.length / 4 && data.length / 2 != 0) {//解决复杂度震荡，当size == capacity/4时，才将capa减半
            resize(data.length / 2);
        }
        return remove;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    //从数组中删除元素e
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.remove(4);
        System.out.println(arr);
    }
}
