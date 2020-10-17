package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class LargestPrimeFactorTestCase extends AbstractTestCase {

    private LargestPrimeFactor classUnderTest;

    private static final Integer IS_PRIME_NUMBER = 2;
    private static final Integer NOT_PRIME_NUMBER = 1;
    private static final Integer NON_NATURAL_NUMBER = 0;
    private static final Integer NATURAL_NUMBER = 10;

    @Before
    public void initialize() {
        classUnderTest = new LargestPrimeFactor();
    }

    @Test
    public void noOp() {
        assertTrue(true);
    }

    @Test
    public void givenCollection_WhenLargestNumberTest_ThenSuccess() {
        assertEquals(50L, classUnderTest.largestNumber(assembleNumberCollection()).longValue());
    }

    @Test
    public void givenCollection_WhenLargestNumberTest_ThenFail() {
        assertNotEquals(10L, classUnderTest.largestNumber(assembleNumberCollection()).longValue());
    }

    @Test
    public void givenNumber_WhenRetrieveLargestPrimeFactorSimpleTest_ThenSuccess() {
        assertEquals(6857L, classUnderTest.retrieveLargestPrimeFactorSimple(600851475143L).longValue());
    }

    private Collection<Long> assembleNumberCollection() {
        return Collections.unmodifiableList(Arrays.asList(10L,20L,30L,40L,50L));
    }
}