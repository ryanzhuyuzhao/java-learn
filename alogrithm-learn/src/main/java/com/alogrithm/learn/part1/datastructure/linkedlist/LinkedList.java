package com.alogrithm.learn.part1.datastructure.linkedlist;

/**
 * @ClassName LinkedList
 * @Description 链表数据结构
 * @Author Administrator
 * @Date 2021/8/23 0023 20:11
 * @Version 1.0
 */
public class LinkedList<E> {

    private Node dummyHead;//添加链表头的位置比较特殊，添加元素时需要找到index位置之前的位置元素，所以添加链表头要单独处理，而为了不做这样的单独处理，我们可以在链表中添加一个虚拟的链表头
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向链表头加元素
    public void addFirst(E e) {
        add(0,e);
    }

    //在链表index（0-based）位置添加新元素e
    //在链表中不是一个常用的操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }
        /*if (index == 0) {//添加链表头的位置比较特殊，添加元素时需要找到index位置之前的位置元素，所以添加链表头要单独处理，而为了不做这样的单独处理，我们可以在链表中添加一个虚拟的链表头
            addFirst(e);
        }else {
            Node pre = head;
            for (int i = 0;i < index - 1; i++) {
                pre = pre.next;
            }
            pre.next = new Node(e,pre.next);
            size++;
        }*/
        Node pre = dummyHead;
        for (int i = 0;i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;

    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size,e);
    }

    //获得链表的第index（0-based）个位置的元素
    //链表中不是一个常用的操作，练习用
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //更新链表的第index（0-based）个位置的元素为e
    //链表中不是一个常用的操作，练习用
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            if (cur.equals(e)) {
                return true;
            }
        }
        return false;
    }

    //获取链表的最后一个元素（0-based）位置的元素，返回删除的元素
    //
    public E getLast() {
        return get(size - 1);
    }

    //从链表中删除index
    //链表中不是一个常用的操作，练习用
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    //从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的 元素
    public E removeLast() {
        return remove(size - 1);
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
