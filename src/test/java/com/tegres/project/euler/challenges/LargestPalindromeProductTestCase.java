package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import com.tegres.project.euler.domain.PalindromeProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPalindromeProductTestCase extends AbstractTestCase {

    private LargestPalindromeProduct classUnderTest;
    private static Integer LOWEST_NUMBER = 100;
    private static Integer HIGHEST_NUMBER = 999;
    private static final Integer PALINDROME = 580085;

    @Before
    public void initialize() {
        classUnderTest = new LargestPalindromeProduct();
    }

    @Test
    public void givenLargestNumber_WhenCalculate_ThenCorrect() {
        PalindromeProduct actual = classUnderTest.execute(LOWEST_NUMBER, HIGHEST_NUMBER);
        verifyTestResult(actual);
    }

    private void verifyTestResult(PalindromeProduct actual) {
        assertEquals(PALINDROME, actual.getPalindromeNumber());
    }
}