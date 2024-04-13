package com.library.lms.service.validator.impl;

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
public class ReturnUserValidator implements Validator {

    @Override
    public void validate(Transaction transaction) {

        if (!transaction.getUserEntity().equals(transaction.getBookEntity().getUser())) {
            throw new InternalException(InternalExceptionReason.BOOK_OWNER_AND_USER_MISMATCH, "User id: " + transaction.getUser().getId());
        }

    }
}
