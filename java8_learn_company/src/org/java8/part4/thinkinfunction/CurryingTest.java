package org.java8.part4.thinkinfunction;

import java.util.function.DoubleUnaryOperator;

/**
 * 科里化测试
 */
public class CurryingTest {
    public static void main(String[] args) {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0/5, 32);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.6214, 0);

        double gdp = convertUSDtoGBP.applyAsDouble(1000);
        System.out.println(gdp);
    }

    public static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }
}
