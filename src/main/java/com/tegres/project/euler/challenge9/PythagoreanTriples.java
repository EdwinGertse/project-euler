package com.tegres.project.euler.challenge9;

import com.tegres.project.euler.common.Preconditions;
import com.tegres.project.euler.validation.RuleIsPythagoreanTripleAttributes;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Function;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @author Edwin Gertse
 */
public class PythagoreanTriples {

    public static void main(String[] args) {
        Map<String, String> triples = constructPythagoreanTriples(3, 2);
        System.out.println("Pythagorean Triplet: " + triples);
        System.out.println("Is Pythagorean Triple: " + isPythagoreanTripleAttributes(triples));
    }

    private static Map<String, String> constructPythagoreanTriples(Integer param1, Integer param2) {
        Preconditions.notNull(param1, "Number <param1> should not be NULL");
        Preconditions.notNull(param2, "Number <param2> should not be NULL");

        Argument m = new Argument("m");
        m.setArgumentValue(param1);
        Argument n = new Argument("n");
        n.setArgumentValue(param2);

        Map<String, String> triples = new HashMap<>();
        triples.put(Labels.A, calculatePythagoreanValue(PythagoreanTriplesFunction.a, m, n));
        triples.put(Labels.B, calculatePythagoreanValue(PythagoreanTriplesFunction.b, m, n));
        triples.put(Labels.C, calculatePythagoreanValue(PythagoreanTriplesFunction.c, m, n));

        return triples;
    }

    private static String calculatePythagoreanValue(String functionName, Argument m, Argument n) {
        Function function = new Function(functionName);
        return String.valueOf((int)function.calculate(m, n));
    }

    private static boolean isPythagoreanTripleAttributes(Map<String, String> PythagoreanTripleSet) {
        Collection<String> numbers = PythagoreanTripleSet.values();
        return new RuleIsPythagoreanTripleAttributes().evaluate(numbers);
    }
}
