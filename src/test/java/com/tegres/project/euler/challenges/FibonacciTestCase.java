package com.tegres.project.euler.challenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTestCase {

    private Fibonacci classUnderTest;
    private static final Integer EXPECTED = 44;
    private static final Integer FIBONACCI_SIZE = 10;

    @BeforeEach
    public void setup() {
        classUnderTest = new Fibonacci();
    }

    @Test
    public void testSumOfEvenNumbers() {
        Integer actual = classUnderTest.sumOfEvenNumbers(FIBONACCI_SIZE);
        assertEquals(EXPECTED, actual, String.format("Actual number <%s> doesn't match expected <%s>", actual, EXPECTED));
    }
}
