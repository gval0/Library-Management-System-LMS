package com.library.lms.service.resolver.impl;

import com.library.lms.entity.BookEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;
import com.library.lms.service.bo.BookService;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookResolver implements Resolver {

    private final BookService bookService;

    @Override
    public Transaction resolve(Transaction transaction) {

        if(transaction.getBook() == null || transaction.getBook().getId() == null) {
           throw  new InternalException(InternalExceptionReason.GENERAL_ERROR, "Book id not valid");
        }

        BookEntity entity = bookService.getEntityById((transaction.getBook().getId()));

        transaction.updateBookEntity(entity);
        transaction.updateBook(Mapper.getBook(entity));

        return transaction;

    }
}
