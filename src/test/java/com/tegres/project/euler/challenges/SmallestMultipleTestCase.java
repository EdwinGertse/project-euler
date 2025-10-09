package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestMultipleTestCase extends AbstractTestCase {

    private SmallestMultiple classUnderTest;

    private static Integer MIN_NUMBER = 1;
    private static Integer MAX_NUMBER = 20;

    private static Integer SMALLEST_MULTIPLE = 232792560;
    @BeforeEach
    public void initialize() {
        classUnderTest = new SmallestMultiple();
    }

    @Test
    public void givenNumberRange_WhenCalculatingSmallestMultiple_ThenCorrect() {
        assertEquals(Integer.valueOf(SMALLEST_MULTIPLE), classUnderTest.smallestMultiple(MIN_NUMBER, MAX_NUMBER));
    }

}
