package org.java8.part3.date_java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017,12,18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20171218
        System.out.println(s1);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2017-12-18
        System.out.println(s2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2017,12,18);
        String formatteredDate = date1.format(formatter);
        System.out.println(formatteredDate);
        LocalDate date2 = LocalDate.parse(formatteredDate,formatter);
        System.out.println(date2);
    }
}
