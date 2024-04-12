package com.library.lms.service.validator;

import com.library.lms.entity.enums.UserRole;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;

public class BorrowUserValidator implements Validator {

    @Override
    public void validate(Transaction transaction) {

        if (transaction.getUser().getUserRole() == UserRole.ADMIN) {
            throw new InternalException(InternalExceptionReason.USER_ADMIN_NOT_ALLOWED_TO_BORROW, "");
        }

    }
}
