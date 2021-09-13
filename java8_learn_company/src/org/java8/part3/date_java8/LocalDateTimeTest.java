package org.java8.part3.date_java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.DECEMBER,18,14,18,17);
        System.out.println("date and time: " + dt1);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dt2 = LocalDateTime.of(date,time);
        System.out.println("date and time: " + dt2);
        System.out.println("date: " + dt2.toLocalDate());
        System.out.println("time: " + dt2.toLocalTime());
        LocalDateTime dt3 = date.atTime(14,21,38);
        System.out.println("date and time: " + dt3);
        LocalDateTime dt4 = date.atTime(time);
        System.out.println("date and time: " + dt4);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println("date and time: " + dt5);
    }
}
