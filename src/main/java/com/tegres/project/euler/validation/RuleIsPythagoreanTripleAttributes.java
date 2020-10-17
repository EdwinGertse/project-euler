package com.tegres.project.euler.validation;

import com.tegres.project.euler.common.NumberTheoryEnum;

import java.util.Collection;

public class RuleIsPythagoreanTripleAttributes implements Rule<Boolean, Collection<String>> {

    @Override
    public Boolean evaluate(Collection<String> input) {
        return input.stream().allMatch(number -> NumberTheoryEnum.IS_NOT_NULL
                .and(NumberTheoryEnum.IS_POSITIVE)
                .test(Integer.parseInt(number)));
    }
}
