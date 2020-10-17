package com.tegres.project.euler.challenge5;

import com.tegres.project.euler.base.AbstractTestCase;
import com.tegres.project.euler.challenges.SmallestMultiple;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SmallestMultipleTestCase extends AbstractTestCase {

    private SmallestMultiple classUnderTest;

    private static Integer MIN_NUMBER = 1;
    private static Integer MAX_NUMBER = 20;

    private static Integer SMALLEST_MULTIPLE = 232792560;
    @Before
    public void initialize() {
        classUnderTest = new SmallestMultiple();
    }

    @Test
    public void givenNumberRange_WhenCalculatingSmallestMultiple_ThenCorrect() {
        Assert.assertEquals(Integer.valueOf(SMALLEST_MULTIPLE), classUnderTest.smallestMultiple(MIN_NUMBER, MAX_NUMBER));
    }

}