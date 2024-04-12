package com.library.lms.controller;

import com.library.lms.controller.request.BorrowBookRequest;
import com.library.lms.model.Transaction;
import com.library.lms.util.Facade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private Facade facade;

    @PostMapping("/borrow_book")
    public ResponseEntity<Transaction> borrowBook(@RequestBody @Valid BorrowBookRequest request) {
        return ResponseEntity.ok(facade.borrowBook(request));
    }
}
