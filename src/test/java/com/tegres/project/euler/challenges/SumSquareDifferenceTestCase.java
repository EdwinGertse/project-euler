package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumSquareDifferenceTestCase extends AbstractTestCase {

    private SumSquareDifference classUnderTest;

    private static Integer MAX_NUMBER = 100;

    private static Double SUM_OF_SQUARES = 338350.0;
    private static Double SQUARE_OF_SUM = 25502500.0;
    private static Double DIFFERENCE_BETWEEN_SUM_OF_SQUARE_AND_SQUARE_OF_SUM = 25164150.0;

    @Before
    public void initialize() {
        classUnderTest = new SumSquareDifference();
    }

    @Test
    public void givenNumber_WhenCalculatingSumOfSquares_ThenCorrect() {
        Assert.assertEquals(formatResult(SUM_OF_SQUARES),
                String.format("%.2f", classUnderTest.sumOfSquares(MAX_NUMBER)));
    }

    @Test
    public void givenNumber_WhenCalculatingSquareOfSum_ThenCorrect() {
        Assert.assertEquals(formatResult(SQUARE_OF_SUM),
                String.format("%.2f", classUnderTest.squareOfSum(MAX_NUMBER)));
    }

    @Test
    public void whenCalculateDifference_ThenCorrect() {
        Assert.assertEquals(formatResult(DIFFERENCE_BETWEEN_SUM_OF_SQUARE_AND_SQUARE_OF_SUM),
                String.format("%.2f", classUnderTest.calculateDifference(MAX_NUMBER)));
    }

    private String formatResult(Double value) {
        return String.format("%.2f", Double.valueOf(value));
    }
}