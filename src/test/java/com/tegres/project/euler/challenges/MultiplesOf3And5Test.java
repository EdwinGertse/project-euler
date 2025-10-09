package com.tegres.project.euler.challenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplesOf3And5Test {

    private static final Integer MAX_NUMBER = 1000;
    private static final Integer EXPECTED = 233168;

    private MultiplesOf3And5 classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new MultiplesOf3And5();
    }

    @Test
    public void testSumOfMultiplesOf3And5() {
        assertEquals(EXPECTED, classUnderTest.sumOfMultiples(MAX_NUMBER));
    }
}
