package org.java8.part4.thinkinfunction.streamdelay;

public interface MyList<T> {
    T head();
    MyList<T> tail();
    default boolean isEmpty() {
        return true;
    }

}
