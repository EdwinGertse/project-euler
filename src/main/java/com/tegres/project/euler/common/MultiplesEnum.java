package com.tegres.project.euler.common;

import java.util.function.Predicate;

public enum MultiplesEnum implements Predicate<Number> {
    MULITPLES_OF_THREE(num -> num instanceof Integer && Math.floorMod(num.intValue(), 3) == 0),
    MULITPLES_OF_FIVE(num -> num instanceof Integer && Math.floorMod(num.intValue(), 5) == 0);

    private final Predicate<Number> predicate;

    MultiplesEnum(final Predicate<Number> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(final Number number) {
        return predicate.test(number);
    }
}
