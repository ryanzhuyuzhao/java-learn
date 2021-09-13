package org.java8.part3.date_java8;

import java.time.Period;

public class PeriodTest {
    public static void main(String[] args) {
        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays.getDays());
        Period threeWeeks = Period.ofWeeks(3);
        System.out.println(threeWeeks.getDays());
        Period twoYearsSixMonthsOneDay = Period.of(3,6,1);
        System.out.println(twoYearsSixMonthsOneDay.getYears());
    }
}
