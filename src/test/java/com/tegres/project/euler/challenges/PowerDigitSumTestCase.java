package com.tegres.project.euler.challenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerDigitSumTestCase {
    private PowerDigitSum classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new PowerDigitSum();
    }

    @ParameterizedTest
    @MethodSource("customParameters")
    public void testSumOfPowerDigit(Integer value, Integer powerDigit, Integer expectedResult) {
        assertThat(classUnderTest.execute(value, powerDigit)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> customParameters() {
        return Stream.of(Arguments.of(2, 15, 26),
            Arguments.of(2, 1000, 1366));
    }
}
