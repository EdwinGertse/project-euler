package com.tegres.project.euler.common;

import com.tegres.project.euler.exception.PreconditionViolationException;

import java.util.function.Supplier;

public final class Preconditions {

    private Preconditions(){}

    private static void condition(boolean predicate, String message) throws PreconditionViolationException {
        if(!predicate) throw new PreconditionViolationException(message);
    }

    private static void condition(boolean predicate, Supplier<String> messageSupplier) throws PreconditionViolationException {
        if(!predicate) throw new PreconditionViolationException(messageSupplier.get());
    }

    public static <T> T notNull(T obj, String message) throws PreconditionViolationException {
        condition(obj != null, message);
        return obj;
    }

    public static <T> T notNull(T obj, Supplier<String> messageSupplier) throws PreconditionViolationException {
        condition(obj != null, messageSupplier);
        return obj;
    }
}
