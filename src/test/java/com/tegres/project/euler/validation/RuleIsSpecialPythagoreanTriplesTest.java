package com.tegres.project.euler.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuleIsSpecialPythagoreanTriplesTest {

    private RuleIsSpecialPythagoreanTriples classUnderTest;

    @BeforeEach
    public void setup() {
        classUnderTest = new RuleIsSpecialPythagoreanTriples();
    }

    @Test
    public void givenValidPythagoreanTriple_whenEvaluatingSpecialPythagoreanTriple_ReturnsTrue() {
        Collection<String> values = Arrays.asList("9", "16", "25");
        Map<Integer, Collection<String>> input = Map.of(50, values);
        boolean result = classUnderTest.evaluate(input);
        assertTrue(result, "Should return true for a valid special Pythagorean triple where sum equals the key");
    }

    @Test
    public void givenValidPythagoreanTriple_whenEvaluatingSpecialPythagoreanTriple_ReturnsFalse() {
        Collection<String> values = Arrays.asList("3", "4", "5");
        Map<Integer, Collection<String>> input = Map.of(10, values);
        boolean result = classUnderTest.evaluate(input);
        assertFalse(result, "Should return false when the sum doesn't equal the key");
    }

    @Test
    public void givenEmptyMap_whenEvaluatingSpecialPythagoreanTriple_ReturnsFalse() {
        Map<Integer, Collection<String>> input = Collections.emptyMap();
        boolean result = classUnderTest.evaluate(input);
        assertFalse(result, "Should return false for an empty map");
    }

    @Test
    public void givenNegativeNumbers_whenEvaluatingSpecialPythagoreanTriple_ReturnsFalse() {
        Collection<String> values = Arrays.asList("-3", "4", "5");
        Map<Integer, Collection<String>> input = Map.of(6, values);
        boolean result = classUnderTest.evaluate(input);
        assertFalse(result, "Should return false when any number is negative");
    }

    @Test
    public void givenNonNumericValues_whenEvaluatingSpecialPythagoreanTriple_ReturnsFalse() {
        Collection<String> values = Arrays.asList("3", "four", "5");
        Map<Integer, Collection<String>> input = Map.of(12, values);
        assertThrows(NumberFormatException.class, () -> classUnderTest.evaluate(input));
    }
}
