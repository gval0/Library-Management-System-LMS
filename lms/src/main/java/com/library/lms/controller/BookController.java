package com.library.lms.controller;

import com.library.lms.controller.request.book.CreateBookRequest;
import com.library.lms.controller.request.book.UpdateBookRequest;
import com.library.lms.model.Book;
import com.library.lms.service.bo.BookService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
@PreAuthorize("hasRole('ADMIN')")
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<Book> create(@RequestBody @Valid CreateBookRequest request) {
        return ResponseEntity.ok(bookService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") @Valid @NotNull Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") @Valid @NotNull Long id,
                                    @RequestBody @Valid UpdateBookRequest request) {
        return ResponseEntity.ok(bookService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") @Valid @NotNull Long id) {
        bookService.delete(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
