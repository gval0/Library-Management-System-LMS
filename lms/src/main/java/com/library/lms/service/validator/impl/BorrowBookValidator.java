package com.library.lms.service.validator.impl;

import com.library.lms.entity.enums.BookStatus;
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
public class BorrowBookValidator implements Validator {

    @Override
    public void validate(Transaction transaction) {

        if (transaction.getBook().getStatus() == BookStatus.BORROWED) {
            throw new InternalException(InternalExceptionReason.BOOK_NOT_AVAILABLE, "Book id: " + transaction.getBook().getId());
        }

    }

}
