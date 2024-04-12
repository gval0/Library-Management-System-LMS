package com.library.lms.service.validator;

import com.library.lms.entity.enums.BookStatus;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;

public class ReturnBookValidator implements Validator {

    @Override //todo
    public void validate(Transaction transaction) {

        if (transaction.getBook().getStatus() == BookStatus.BORROWED) {
            throw new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book id: " + transaction.getBook().getId());
        }

    }

}
