package com.library.lms.exception;

import lombok.Getter;

@Getter
public class InternalException extends RuntimeException {

    private final InternalExceptionReason reason;

    public InternalException(InternalExceptionReason reason, String message) {
        super(message);
        this.reason = reason;
    }
}
