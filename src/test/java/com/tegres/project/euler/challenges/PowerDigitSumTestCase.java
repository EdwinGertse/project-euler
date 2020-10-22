package com.tegres.project.euler.challenges;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PowerDigitSumTestCase {
    private PowerDigitSum classUnderTest;
    private static final Integer VALUE = 2;
    private static final Integer POWER_DIGIT = 1000;
    private static final Integer EXPECTED = 15863;

    @Before
    public void setup() {
        classUnderTest = new PowerDigitSum();
    }

    @Test
    public void testSumOfPowerDigit() {
        assertThat(classUnderTest.execute(VALUE, POWER_DIGIT)).isEqualTo(EXPECTED);
    }
}