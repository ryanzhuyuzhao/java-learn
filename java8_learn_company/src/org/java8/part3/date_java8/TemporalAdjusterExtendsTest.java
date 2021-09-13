package org.java8.part3.date_java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExtendsTest {
    public static void main(String[] args) {
        /**
         * 该函数实现了TemporalAdjuster接口，能够计算明天的日期，同时过滤掉周六和周日这些节假日。
         */
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
                temporal -> {
                    DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                    int datToAdd = 1;
                    if(dow == DayOfWeek.FRIDAY) datToAdd = 3;
                    if (dow == DayOfWeek.SATURDAY) datToAdd = 2;
                    return temporal.plus(datToAdd, ChronoUnit.DAYS);
                }
        );
        LocalDate date = LocalDate.now();
        date = date.with(nextWorkingDay);
        System.out.println(date);
    }
}
