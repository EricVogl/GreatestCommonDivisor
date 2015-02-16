package com.ericvogl.greatestcommondivisor.calculator;

public class EuclidGcdCalculatorTest extends GcdCalculatorTest {
    @Override
    public void setUp() {
        setCalculator(new EuclidGcdCalculator());
    }
}
