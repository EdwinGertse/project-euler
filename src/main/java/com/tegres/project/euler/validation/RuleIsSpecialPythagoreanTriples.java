package com.tegres.project.euler.validation;

import com.tegres.project.euler.common.NumberTheoryEnum;

import java.util.Collection;
import java.util.Map;

public class RuleIsSpecialPythagoreanTriples implements Rule<Boolean, Map<Integer, Collection<String>>> {

    @Override
    public Boolean evaluate(Map<Integer, Collection<String>> input) {
        if (input.isEmpty())
            return false;
        if (input.values().stream()
            .flatMap(Collection::stream)
            .allMatch(number -> NumberTheoryEnum.IS_NOT_NULL
                .and(NumberTheoryEnum.IS_POSITIVE)
                .test(Integer.parseInt(number)))) {
            return input.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Integer::parseInt)
                .sum() == input.keySet().stream().findFirst().get();
        }
        return false;
    }
}
