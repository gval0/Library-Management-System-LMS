package com.library.lms.service.resolver;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.enums.BookStatus;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;
import com.library.lms.repo.BookRepo;
import com.library.lms.util.Mapper;

public class BookResolver implements Resolver {

    private BookRepo bookRepo;

    @Override
    public Transaction resolve(Transaction transaction) {

        BookEntity entity = bookRepo.findById(transaction.getBook().getId())
                .orElseThrow(() -> new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book not found with id: " + transaction.getBook().getId()));

        transaction.updateBookEntity(entity);
        transaction.updateBook(Mapper.getBook(entity));

        return transaction;
    }
}
