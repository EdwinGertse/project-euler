package com.tegres.project.euler.validation;

import com.tegres.project.euler.common.NumberTheoryEnum;

import java.util.Collection;
import java.util.Map;

public class RuleIsSpecialPythagoreanTriples implements Rule<Long, Map<Integer, Collection<String>>> {

    @Override
    public Long evaluate(Map<Integer, Collection<String>> input) {
        if (input.isEmpty() ||
            input.keySet().stream().noneMatch(NumberTheoryEnum.IS_NOT_NULL.and(NumberTheoryEnum.IS_POSITIVE)))
            return -1L;
        if (input.values().stream()
            .flatMap(Collection::stream)
            .allMatch(number -> NumberTheoryEnum.IS_NOT_NULL
                .and(NumberTheoryEnum.IS_POSITIVE)
                .test(Integer.parseInt(number)))) {
            if (input.values().stream()
                .flatMap(Collection::stream)
                .mapToLong(Long::parseLong)
                .sum() == input.keySet().stream().findFirst().get()) {
                return input.values()
                    .stream()
                    .flatMap(Collection::stream)
                    .mapToLong(Long::parseLong)
                    .reduce((a,b) -> a * b)
                    .getAsLong();
            }
        }
        return -1L;
    }
}
