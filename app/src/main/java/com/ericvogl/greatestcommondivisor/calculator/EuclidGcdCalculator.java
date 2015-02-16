package com.ericvogl.greatestcommondivisor.calculator;

public class EuclidGcdCalculator implements GcdCalculator {
    @Override
    public int calculate(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
