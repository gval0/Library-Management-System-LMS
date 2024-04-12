package com.library.lms.util;

import com.library.lms.controller.request.BorrowBookRequest;
import com.library.lms.model.Transaction;
import com.library.lms.service.processor.BorrowBookProcessor;

public class Facade {

    private BorrowBookProcessor borrowBookProcessor;

    public Transaction borrowBook(BorrowBookRequest request) {
        return borrowBookProcessor.process(request.getTransaction());
    }
}
