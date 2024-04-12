package com.library.lms.service.transaction;

import com.library.lms.model.Transaction;

public interface TransactionService {

    Transaction borrowBook(Transaction transaction);

    Transaction returnBook(Transaction transaction);
}
