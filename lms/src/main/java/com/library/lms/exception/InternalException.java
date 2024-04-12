package com.library.lms.exception;

import lombok.Getter;

@Getter
public class InternalException extends RuntimeException {

    private final InternalExceptionReason reason;
    private final String message;

    public InternalException(InternalExceptionReason reason, String message) {
        this.reason = reason;
        this.message = message;
    }
}
