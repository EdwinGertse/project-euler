package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SummationOfPrimesTest extends AbstractTestCase {

    private SummationOfPrimes classUnderTest;

    private static final Integer START_NUMBER = 0;
    private static final Integer END_NUMBER = 10;

    @BeforeEach
    public void setup() {
        classUnderTest = new SummationOfPrimes();
    }

    @Test
    public void getListOfPrimeNumbers() {
        assertEquals(getListOfNumbers(), classUnderTest.getListOfPrimeNumbers(START_NUMBER, END_NUMBER));
    }

    @Test
    public void sumOfPrimeNumber() {
        assertEquals(17, classUnderTest.sumOfPrimeNumber(getListOfNumbers()).intValue());
    }

    private List<Integer> getListOfNumbers() {
        return Arrays.asList(7, 5, 3, 2);
    }
}
