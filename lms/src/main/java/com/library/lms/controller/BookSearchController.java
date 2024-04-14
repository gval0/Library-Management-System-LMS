package com.library.lms.controller;

import com.library.lms.model.Book;
import com.library.lms.service.search.BookSearchService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/search")
public class BookSearchController {

    private final BookSearchService bookSearchService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String search) {
        return ResponseEntity.ok(bookSearchService.searchBooks(search));
    }

}
