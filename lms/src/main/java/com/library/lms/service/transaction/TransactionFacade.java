package com.library.lms.service.transaction;

import com.library.lms.controller.request.BorrowBookRequest;
import com.library.lms.controller.request.ReturnBookRequest;
import com.library.lms.controller.response.Response;

public interface TransactionFacade {

    Response borrowBook(BorrowBookRequest request);

    Response returnBook(ReturnBookRequest request);

}
