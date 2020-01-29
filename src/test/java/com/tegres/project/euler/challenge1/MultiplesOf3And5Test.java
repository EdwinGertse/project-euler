package com.tegres.project.euler.challenge1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiplesOf3And5Test {

    private static final Integer MAX_NUMBER = 1000;
    private static final Integer EXPECTED = 233168;

    private MultiplesOf3And5 classUnderTest;

    @Before
    public void setup() {
        classUnderTest = new MultiplesOf3And5();
    }

    @Test
    public void testSumOfMultiplesOf3And5() {
        Assert.assertEquals(EXPECTED, classUnderTest.sumOfMultiples(MAX_NUMBER));
    }
}