package org.java8.part3.date_java8;

import java.time.LocalTime;

public class LocalTimeTest {
    public static void main(String[] args) {
//        LocalTime time = LocalTime.of(13,45,20);
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        System.out.println("hour: " + hour);
        int minute = time.getMinute();
        System.out.println("minute: " + minute);
        int second = time.getSecond();
        System.out.println("second: " + second);
    }
}
