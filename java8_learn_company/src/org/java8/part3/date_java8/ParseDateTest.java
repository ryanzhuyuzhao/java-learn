package org.java8.part3.date_java8;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class ParseDateTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2017,12,18);
        System.out.println(date1);
        LocalDate date2 = date1.withYear(2011);
        System.out.println(date2);
        LocalDate date3 = date2.withDayOfMonth(25);
        System.out.println(date3);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR,9);
        System.out.println(date4);

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        LocalDate date5 = LocalDate.of(2017,12,18);
        System.out.println(date5);
        LocalDate date6 = date5.plusWeeks(1);
        System.out.println(date6);
        LocalDate date7 = date6.minusYears(3);
        System.out.println(date7);
        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);
        System.out.println(date8);
    }
}
