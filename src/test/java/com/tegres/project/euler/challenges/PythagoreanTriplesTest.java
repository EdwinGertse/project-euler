package com.tegres.project.euler.challenges;

import com.tegres.project.euler.base.AbstractTestCase;
import com.tegres.project.euler.exception.PreconditionViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PythagoreanTriplesTest extends AbstractTestCase {

    private PythagoreanTriples pythagoreanTriples;

    @BeforeEach
    public void setUp() {
        pythagoreanTriples = new PythagoreanTriples();
    }

    @Test
    public void testConstructPythagoreanTriples_ValidInput() {
        Map<String, String> result = pythagoreanTriples.constructPythagoreanTriples(2, 1);

        assertEquals("3", result.get("a"));
        assertEquals("4", result.get("b"));
        assertEquals("5", result.get("c"));
    }

    @Test
    public void testConstructPythagoreanTriples_ConsecutiveNumbers() {
        Map<String, String> result = pythagoreanTriples.constructPythagoreanTriples(3, 2);

        assertEquals("5", result.get("a"));
        assertEquals("12", result.get("b"));
        assertEquals("13", result.get("c"));
    }

    @Test
    public void testConstructPythagoreanTriples_NullParam1() {

        PreconditionViolationException exception = assertThrows(PreconditionViolationException.class, 
            () -> pythagoreanTriples.constructPythagoreanTriples(null, 1),
            "Expected PreconditionViolationException but no exception was thrown");

        assertEquals("Number <param1> should not be NULL", exception.getMessage());
    }

    @Test
    public void testConstructPythagoreanTriples_NullParam2() {

        PreconditionViolationException exception = assertThrows(PreconditionViolationException.class, 
            () -> pythagoreanTriples.constructPythagoreanTriples(2, null),
            "Expected PreconditionViolationException but no exception was thrown");

        assertEquals("Number <param2> should not be NULL", exception.getMessage());
    }

    @Test
    public void testConstructPythagoreanTriples_Param1NotGreaterThanParam2() {

        PreconditionViolationException exception = assertThrows(PreconditionViolationException.class, 
            () -> pythagoreanTriples.constructPythagoreanTriples(1, 2),
            "Expected PreconditionViolationException but no exception was thrown");

        assertEquals("1 must be greater than 2", exception.getMessage());
    }

    @Test
    public void testIsPythagoreanTripleAttributes() {

        Map<String, String> validTriple = Map.of("a", "3", "b", "4", "c", "5");
        boolean result = pythagoreanTriples.isPythagoreanTripleAttributes(validTriple);

        assertTrue(result, "Should return true for valid Pythagorean triple attributes");
    }

    @Test
    public void testIsPythagoreanTripleAttributes_NegativeNumber() {

        Map<String, String> invalidTriple = Map.of("a", "-3", "b", "4", "c", "5");
        boolean result = pythagoreanTriples.isPythagoreanTripleAttributes(invalidTriple);

        assertFalse(result, "Should return false when any number is negative");
    }

    @Test
    public void testIsSpecialPythagoreanTriples_SumEqualsTarget() {

        Map<String, String> triple = Map.of("a", "3", "b", "4", "c", "5");
        boolean result = pythagoreanTriples.isSpecialPythagoreanTriples(12, triple);

        assertTrue(result, "Should return true when sum equals target");
    }

    @Test
    public void testIsSpecialPythagoreanTriples_SumNotEqualsTarget() {

        Map<String, String> triple = Map.of("a", "3", "b", "4", "c", "5");
        boolean result = pythagoreanTriples.isSpecialPythagoreanTriples(13, triple);

        assertFalse(result, "Should return false when sum doesn't equal target");
    }

    @Test
    public void testComprehensivePythagoreanTriples() {
        Map<String, String> triples = pythagoreanTriples.constructPythagoreanTriples(5, 2);
        // Verify the calculated values: a = m² - n² = 5² - 2² = 25 - 4 = 21
        assertEquals("21", triples.get("a"), "Value of 'a' should be 21");
        // Verify the calculated values: b = 2mn = 2 * 5 * 2 = 20
        assertEquals("20", triples.get("b"), "Value of 'b' should be 20");
        // Verify the calculated values: c = m² + n² = 5² + 2² = 25 + 4 = 29
        assertEquals("29", triples.get("c"), "Value of 'c' should be 29");

        // Check that these values satisfy the Pythagorean triple attributes (all positive)
        boolean isPythagoreanTriple = pythagoreanTriples.isPythagoreanTripleAttributes(triples);
        assertTrue(isPythagoreanTriple, "The constructed values should be valid Pythagorean triple attributes");

        // Calculate the sum of the triple values: 21 + 20 + 29 = 70
        int sum = Integer.parseInt(triples.get("a")) + 
                  Integer.parseInt(triples.get("b")) + 
                  Integer.parseInt(triples.get("c"));

        // Check that isSpecialPythagoreanTriples returns true when the target equals the sum
        boolean isSpecialTriple = pythagoreanTriples.isSpecialPythagoreanTriples(sum, triples);
        assertTrue(isSpecialTriple, "Should return true when target equals the sum of the triple values");

        // Check that isSpecialPythagoreanTriples returns false when the target doesn't equal the sum
        boolean isNotSpecialTriple = pythagoreanTriples.isSpecialPythagoreanTriples(sum + 1, triples);
        assertFalse(isNotSpecialTriple, "Should return false when target doesn't equal the sum of the triple values");
    }

    @Test
    void determineProductBasedOnGivenValue() {
        var product = pythagoreanTriples.arithmeticPythagoreanTriples(1000);
        assertThat(product).isEqualTo(31875000);
    }
}
