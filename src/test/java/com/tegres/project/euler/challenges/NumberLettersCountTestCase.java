package com.tegres.project.euler.challenges;


import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberLettersCountTestCase {
    private NumberLettersCount classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new NumberLettersCount();
    }

    @ParameterizedTest
    @MethodSource("numberLettersCounterArguments")
    public void testNumberToLetterCount(Triple<Integer, Integer, Integer> arguments) {
        assertThat(classUnderTest.execute(arguments.getLeft(),arguments.getMiddle()))
            .isEqualTo(arguments.getRight());
    }

    private static Stream<Arguments> numberLettersCounterArguments() {
        return Stream.of(Arguments.of(Triple.of( 1, 5, 19)),
            Arguments.of(Triple.of( 100, 564, 10321)));
    }
}
