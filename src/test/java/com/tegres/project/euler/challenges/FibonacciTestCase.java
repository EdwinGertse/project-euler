package com.tegres.project.euler.challenges;

import com.tegres.project.euler.challenges.Fibonacci;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTestCase {

    private Fibonacci classUnderTest;
    private static final Integer EXPECTED = 44;
    private static final Integer FIBONACCI_SIZE = 10;

    @Before
    public void setup() {
        classUnderTest = new Fibonacci();
    }

    @Test
    public void testSumOfEvenNumbers() {
        Integer actual = classUnderTest.sumOfEvenNumbers(FIBONACCI_SIZE);
        Assert.assertEquals(String.format("Actual number <%s> doesn't match expected <%s>", actual, EXPECTED),
                EXPECTED, actual);
    }
}