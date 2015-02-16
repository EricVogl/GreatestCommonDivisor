package com.ericvogl.greatestcommondivisor.calculator;

import junit.framework.TestCase;

public abstract class GcdCalculatorTest extends TestCase {
    private GcdCalculator _calculator;

    public abstract void setUp();

    protected void setCalculator(GcdCalculator calculator) {
        _calculator = calculator;
    }

    public void testCalculate_firstNumberGreaterThanSecondAndSecondIsTheGcd_calculatesGcd() {
        assertEquals(6, _calculator.calculate(12, 6));
    }

    public void testCalculate_secondNumberGreaterThanFirstAndFirstIsTheGcd_calculatesGcd() {
        assertEquals(6, _calculator.calculate(6, 12));
    }

    public void testCalculate_firstNumberIsZero_returnsOtherNumber() {
        assertEquals(1, _calculator.calculate(0, 1));
    }

    public void testCalculate_secondNumberIsZero_returnsOtherNumber() {
        assertEquals(1, _calculator.calculate(1, 0));
    }

    public void testCalculate_bothNumbersAreZero_returnsZero() {
        assertEquals(0, _calculator.calculate(0, 0));
    }

    public void testCalculate_coPrimeNumbersLessFirst_returnsOne() {
        assertEquals(1, _calculator.calculate(4, 9));
    }

    public void testCalculate_coPrimeNumbersGreaterFirst_returnsOne() {
        assertEquals(1, _calculator.calculate(9, 4));
    }

    public void testCalculate_hasGcdNotEqualToParameterLessFirst_returnsGcd() {
        assertEquals(6, _calculator.calculate(18, 24));
    }

    public void testCalculate_hasGcdNotEqualToParameterGreaterFirst_returnsGcd() {
        assertEquals(6, _calculator.calculate(24, 18));
    }

    public void testCalculate_negativeValueFirst_returnsGcd() {
        assertEquals(6, _calculator.calculate(-24, 18));
    }

    public void testCalculate_negativeValueSecond_returnsGcd() {
        assertEquals(6, _calculator.calculate(18, -24));
    }

    public void testCalculate_bothNegative_returnsGcd() {
        assertEquals(6, _calculator.calculate(-24, -18));
    }
}
