package com.tegres.project.euler.validation;

public interface Rule<R, I> {
    @SuppressWarnings("unused")
    R evaluate(I input);
}
