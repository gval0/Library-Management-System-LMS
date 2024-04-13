package com.library.lms.controller;

import com.library.lms.controller.request.BorrowBookRequest;
import com.library.lms.controller.request.ReturnBookRequest;
import com.library.lms.controller.response.Response;
import com.library.lms.service.transaction.TransactionFacade;
import com.library.lms.service.transaction.impl.TransactionFacadeImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionFacade facade;

    @PostMapping("/borrow_book")
    public ResponseEntity<Response> borrowBook(@RequestBody @Valid BorrowBookRequest request) {
        return ResponseEntity.ok(facade.borrowBook(request));
    }

    @PostMapping("/return_book")
    public ResponseEntity<Response> returnBook(@RequestBody @Valid ReturnBookRequest request) {
        return ResponseEntity.ok(facade.returnBook(request));
    }
}
