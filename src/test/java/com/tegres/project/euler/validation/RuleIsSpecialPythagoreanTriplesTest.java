package com.tegres.project.euler.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuleIsSpecialPythagoreanTriplesTest {

    private RuleIsSpecialPythagoreanTriples classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new RuleIsSpecialPythagoreanTriples();
    }

    @Test
    public void givenValidPythagoreanTriple_whenEvaluatingSpecialPythagoreanTriple_ReturnsProductValue() {
        Collection<String> values = Arrays.asList("9", "16", "25");
        Map<Integer, Collection<String>> input = Map.of(50, values);
        var result = classUnderTest.evaluate(input);
        assertEquals(3600, result, "Should return product sum for a valid special Pythagorean triple where sum equals the key");
    }

    @Test
    public void givenValidPythagoreanTriple_whenEvaluatingSpecialPythagoreanTriple_ReturnsNegative() {
        Collection<String> values = Arrays.asList("3", "4", "5");
        Map<Integer, Collection<String>> input = Map.of(10, values);
        var result = classUnderTest.evaluate(input);
        assertEquals(-1, result, "Should return -1 when the sum doesn't equal the key");
    }

    @Test
    public void givenEmptyMap_whenEvaluatingSpecialPythagoreanTriple_ReturnsNegative() {
        Map<Integer, Collection<String>> input = Collections.emptyMap();
        var result = classUnderTest.evaluate(input);
        assertEquals(-1, result, "Should return -1 for an empty map");
    }

    @Test
    public void givenNegativeNumbers_whenEvaluatingSpecialPythagoreanTriple_ReturnsNegative() {
        Collection<String> values = Arrays.asList("-3", "4", "5");
        Map<Integer, Collection<String>> input = Map.of(6, values);
        var result = classUnderTest.evaluate(input);
        assertEquals(-1, result, "Should return -1 when any number is negative");
    }

    @Test
    public void givenNonNumericValues_whenEvaluatingSpecialPythagoreanTriple_ReturnsNegative() {
        Collection<String> values = Arrays.asList("3", "four", "5");
        Map<Integer, Collection<String>> input = Map.of(12, values);
        assertThrows(NumberFormatException.class, () -> classUnderTest.evaluate(input));
    }
}
