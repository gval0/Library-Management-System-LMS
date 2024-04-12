package com.library.lms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum InternalExceptionReason implements ExceptionReason, Serializable {

    GENERAL_ERROR(1000, "General error"),

    BOOK_NOT_FOUND(1001, "Book not found"),

    BOOK_NOT_AVAILABLE(1002, "Book not available"),

    USER_NOT_FOUND(1003, "User not found"),

    USER_ADMIN_NOT_ALLOWED_TO_BORROW(1004, "Admin user not allowed to borrow book");

    private final int reasonCode;

    private final String reason;

    @Override
    public int getReasonCode() {
        return reasonCode;
    }

    @Override
    public String getReason() {
        return reason;
    }

}
