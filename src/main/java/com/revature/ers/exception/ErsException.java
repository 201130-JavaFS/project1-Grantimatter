package com.revature.ers.exception;

public class ErsException extends RuntimeException {
    public ErsException() {
        super();
    }

    public ErsException(final String message) {
        super(message);
    }
}
