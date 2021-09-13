package org.java8.part4.thinkinfunction.streamdelay;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class LazyList<T> implements MyList<T> {
    final T head;
    final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();//注意，与之前的head不同，这里tail使用了一个Supplier方法提供了延迟性
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /*public MyList<T> filter(Predicate<T> p) {
        return isEmpty() ? this :
                p.test(head()) ?
                        new LazyList<>(head, () -> tail().f)
    }*/
}
