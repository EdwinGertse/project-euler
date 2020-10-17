package com.tegres.project.euler.common;

import java.util.Objects;
import java.util.function.Predicate;

public enum NumberTheoryEnum implements Predicate<Number> {

    IS_NOT_NULL(Objects::nonNull, "Item is null"),
    IS_NOT_AN_INTEGER(item -> item instanceof Integer, "Item is not an integer"),
    IS_POSITIVE(item -> item instanceof Integer && (Integer) item > 0, "Item is negative"),
    IS_EVEN(item -> item instanceof Integer && Math.floorMod(item.intValue(), 2) == 0, "Item is even");

    private final Predicate<Number> predicate;
    private final String reason;

    NumberTheoryEnum(final Predicate<Number> predicate, final String reason) {
        this.predicate = predicate;
        this.reason = reason;
    }

    @Override
    public boolean test(final Number item) {
        final boolean isNotValid = predicate.negate().test(item);
        if (isNotValid) {
            System.out.println(String.format("Invalid %s. Cause: %s", item, reason));
        }
        return predicate.test(item);
    }

}
