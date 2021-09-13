package org.java8.part3.date_java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2017,12,18);
        System.out.println(date1);
        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date2);
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date3);
    }
}
