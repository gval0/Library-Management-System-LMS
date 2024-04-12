package com.library.lms.service.transaction;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.enums.BookStatus;
import com.library.lms.model.Transaction;
import com.library.lms.repo.BookRepo;
import com.library.lms.repo.TransactionRepo;
import com.library.lms.repo.UserRepo;
import com.library.lms.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class transactionServiceImpl implements TransactionService {

    private BookRepo bookRepo;
    private UserRepo userRepo;
    private TransactionRepo transactionRepo;


    @Override
    public Transaction borrowBook(Transaction transaction) {

        BookEntity bookEntity = transaction.getBookEntity();
        bookEntity.setStatus(BookStatus.BORROWED);
        bookEntity.setUser(transaction.getUserEntity());
        bookRepo.save(bookEntity);

        transaction.getTransactionEntity().setDate(new Date());
        return Mapper.getTransaction(transactionRepo.save(transaction.getTransactionEntity()));

    }

    @Override
    public Transaction returnBook(Transaction transaction) {
        return null;
    }
}
