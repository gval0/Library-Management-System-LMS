package com.library.lms.service.transaction.impl;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.TransactionEntity;
import com.library.lms.entity.enums.BookStatus;
import com.library.lms.entity.enums.TransactionType;
import com.library.lms.model.Transaction;
import com.library.lms.repo.BookRepo;
import com.library.lms.repo.TransactionRepo;
import com.library.lms.service.transaction.TransactionService;
import com.library.lms.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final BookRepo bookRepo;

    private final TransactionRepo transactionRepo;

    @Override
    public Transaction borrowBook(Transaction transaction) {

        BookEntity bookEntity = transaction.getBookEntity();
        bookEntity.setStatus(BookStatus.BORROWED);
        bookEntity.setUser(transaction.getUserEntity());
        bookRepo.save(bookEntity);

        TransactionEntity transactionEntity = transaction.getTransactionEntity();
        transactionEntity.setType(TransactionType.BORROW);

        return Mapper.getTransaction(transactionRepo.save(transactionEntity));

    }

    @Override
    public Transaction returnBook(Transaction transaction) {

        BookEntity bookEntity = transaction.getBookEntity();
        bookEntity.setStatus(BookStatus.AVAILABLE);
        bookEntity.setUser(null);
        bookRepo.save(bookEntity);

        TransactionEntity transactionEntity = transaction.getTransactionEntity();
        transactionEntity.setType(TransactionType.RETURN);

        return Mapper.getTransaction(transactionRepo.save(transactionEntity));

    }
}
