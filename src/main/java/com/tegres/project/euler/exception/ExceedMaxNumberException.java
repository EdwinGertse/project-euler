package com.tegres.project.euler.exception;

public class ExceedMaxNumberException extends RuntimeException {

    public ExceedMaxNumberException(String message) {
        super(message);
    }

    public ExceedMaxNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
