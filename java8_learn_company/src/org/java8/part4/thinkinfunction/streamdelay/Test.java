package org.java8.part4.thinkinfunction.streamdelay;

public class Test {
    public static void main(String[] args) {
        /*MyList<Integer> list = new MyLinkedList<>(5,new MyLinkedList<>(10,new Empty<>()));
        System.out.println("tail: " + list.tail());
        System.out.println("head: " + list.head());*/

        //延迟stream
        LazyList<Integer> numbers = from(2);
        int two = numbers.head;
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();
        System.out.println(two + " " + three + " " + four);
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<Integer>(n, () -> from(n + 1));
    }

}
