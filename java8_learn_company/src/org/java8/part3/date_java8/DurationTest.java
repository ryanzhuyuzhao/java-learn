package org.java8.part3.date_java8;

import java.time.*;

public class DurationTest {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(14,38,11);
        LocalTime time2 = LocalTime.now();
        Duration d1 = Duration.between(time1,time2);
        System.out.println(d1.getSeconds());

        LocalDateTime dateTime1 = LocalDateTime.of(2017, Month.DECEMBER,17,14,40,11);
        LocalDateTime dateTime2 = LocalDateTime.now();
        Duration d2 = Duration.between(dateTime1,dateTime2);
        System.out.println(d2.getSeconds());
        Instant t1 = Instant.ofEpochSecond(100000000);
        Instant t2 = Instant.now();
        Duration d3 = Duration.between(t1,t2);
        System.out.println(d3.getSeconds());
    }
}
