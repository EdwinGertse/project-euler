package com.tegres.project.euler.challenges;

import com.tegres.project.euler.common.Preconditions;
import com.tegres.project.euler.common.PythagoreanTriplesFunction;
import com.tegres.project.euler.validation.RuleIsPythagoreanTripleAttributes;
import com.tegres.project.euler.validation.RuleIsSpecialPythagoreanTriples;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Function;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * <br/>
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <br/>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @author Edwin Gertse
 */
public class PythagoreanTriples {

    public long arithmeticPythagoreanTriples(int sum) {
        for (int a = 1; a < sum / 3; a++) {
            for (int b = a + 1; b < (sum - a) / 2; b++) {
                int c = sum - a - b;
                if (a * a + b * b == c * c) {
                    return (long) a * b * c;
                }
            }
        }
        return -1;
    }

    public Map<String, String> constructPythagoreanTriples(Integer param1, Integer param2) {
        Preconditions.notNull(param1, "Number <param1> should not be NULL");
        Preconditions.notNull(param2, "Number <param2> should not be NULL");
        Preconditions.condition(param1 > param2, String.format("%s must be greater than %s", param1, param2));

        Argument m = new Argument("m", param1);
        Argument n = new Argument("n", param2);

        Map<String, String> triples = new HashMap<>();
        triples.put("a", calculatePythagoreanValue(PythagoreanTriplesFunction.a, m, n));
        triples.put("b", calculatePythagoreanValue(PythagoreanTriplesFunction.b, m, n));
        triples.put("c", calculatePythagoreanValue(PythagoreanTriplesFunction.c, m, n));

        return triples;
    }

    public String calculatePythagoreanValue(String functionName, Argument... arguments) {
        Function function = new Function(functionName);
        return String.valueOf((int)function.calculate(arguments));
    }

    public boolean isPythagoreanTripleAttributes(Map<String, String> PythagoreanTripleSet) {
        Collection<String> numbers = PythagoreanTripleSet.values();
        return new RuleIsPythagoreanTripleAttributes().evaluate(numbers);
    }

    public Long isSpecialPythagoreanTriples(Integer target, Map<String, String> PythagoreanTripleSet) {
        var numbers = PythagoreanTripleSet.values();
        var parameter = Map.of(target, numbers);
        return new RuleIsSpecialPythagoreanTriples().evaluate(parameter);
    }
}
