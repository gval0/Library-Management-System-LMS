package com.library.lms.service.validator.impl;

import com.library.lms.entity.enums.UserRole;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;
import com.library.lms.service.validator.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BorrowUserValidator implements Validator {

    @Override
    public void validate(Transaction transaction) {

        if (transaction.getUser().getUserRole() == UserRole.ADMIN) {
            throw new InternalException(InternalExceptionReason.USER_ADMIN_NOT_ALLOWED_TO_BORROW, "");
        }

    }
}
