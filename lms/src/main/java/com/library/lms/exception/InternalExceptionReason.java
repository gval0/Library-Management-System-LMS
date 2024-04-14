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

    USER_ADMIN_NOT_ALLOWED_TO_BORROW(1004, "Admin user not allowed to borrow book"),

    BOOK_AVAILABLE(1005, "Book is not borrowed"),

    BOOK_OWNER_AND_USER_MISMATCH(1006, "User has not borrowed this book"),

    USER_ALREADY_EXISTS(1007, "User already exists");

    private final int reasonCode;

    private final String reason;

    @Override
    public String getReason() {
        return reason;
    }

}
