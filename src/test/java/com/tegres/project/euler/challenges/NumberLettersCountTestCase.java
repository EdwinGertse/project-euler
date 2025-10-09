package com.tegres.project.euler.challenges;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberLettersCountTestCase {
    private NumberLettersCount classUnderTest;

    private static final Integer START = 100;
    private static final Integer END = 564;
    private static final Integer EXPECTED = 10321;

    @BeforeEach
    public void setup() {
        classUnderTest = new NumberLettersCount();
    }

    @Test
    public void testNumberToLetterCount() {
        assertThat(classUnderTest.execute(START,END)).isEqualTo(EXPECTED);
    }
}
