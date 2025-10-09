package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TenThousandthPrimeTestCase extends AbstractTestCase {

    private static final Integer IS_PRIME_NUMBER = 2;
    private static final Integer NOT_PRIME_NUMBER = 1;

    private static final Integer TEN_THOUSANDTH_PRIME = 10001;
    private static final Integer RESULT = 104743;

    private TenThousandthPrime classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new TenThousandthPrime();
    }

    @Test
    public void givenNumber_WhenPrimeNumberTest_ThenSuccess() {
        assertTrue(classUnderTest.isPrimeNumber(IS_PRIME_NUMBER));
    }

    @Test
    public void givenNumber_WhenPrimeNumberTest_ThenFail() {
        assertFalse(classUnderTest.isPrimeNumber(NOT_PRIME_NUMBER));
    }

    @Test
    public void givenPosition_WhenDeterminePrimeNumber_ThenCorrect() {
        assertEquals(RESULT, classUnderTest.determinePrimeNumberSimple(TEN_THOUSANDTH_PRIME));
    }
}
