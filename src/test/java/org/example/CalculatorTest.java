package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {


    @Test
    public void shouldReturnZeroIfInputIsEmptyOrNull() {
        Calculator test = new Calculator();
        assertEquals(0, test.add(""));
        assertEquals(0, test.add(null));
    }

    @Test
    public void shouldAcceptSingleInputAndReturnTheSame() {
        Calculator test = new Calculator();
        assertEquals(3, test.add("3"));
    }

    @Test
    public void shouldReturnAdditionOfTwoNumbers() {
        Calculator test = new Calculator();
        assertEquals(8, test.add("3,5"));
    }

    @Test
    public void shouldReturnAdditionOfMultipleNumbers() {
        Calculator test = new Calculator();
        assertEquals(20, test.add("3,5,4,6,2"));
    }

    @Test(expected = Calculator.InvalidInputException.class)
    public void shouldReturnExceptionForInvalidInput() {
        Calculator test = new Calculator();
        int result = test.add("3,5,3,");
    }

    @Test
    public void shouldReturnAdditionForValidNewLineDelimiter() {
        Calculator test = new Calculator();
        assertEquals(15, test.add("1,2\n3,4\n5"));
    }

    @Test(expected = Calculator.InvalidInputException.class)
    public void shouldReturnExceptionForInvalidDelimiters() {
        Calculator test = new Calculator();
        int result = test.add("3,5,\n3,");
    }

}
