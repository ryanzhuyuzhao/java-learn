package org.java8.part3.progress_api;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42,42);
        });
    }
}
