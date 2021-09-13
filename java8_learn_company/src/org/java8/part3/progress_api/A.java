package org.java8.part3.progress_api;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
