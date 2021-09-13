package org.java8.part3.date_java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateTest {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.of(2017,12,18);
        LocalDate date = LocalDate.now();
        System.out.println("date: " + date);
        int year = date.getYear();
        System.out.println("year: " + year);
        Month month = date.getMonth();
        System.out.println("month: " + month);
        int day = date.getDayOfMonth();
        System.out.println("day: " + day);
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println("day of week: " +dow);
        int len = date.lengthOfMonth();
        System.out.println("length of month: " + len);
        boolean leap = date.isLeapYear();
        System.out.println("Is a leap year? " + leap);

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        int yearT = date.get(ChronoField.YEAR);
        System.out.println("year: " + yearT);
        int monthT = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month: " + monthT);
        int dayT = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println("day: " + dayT);
    }
}
