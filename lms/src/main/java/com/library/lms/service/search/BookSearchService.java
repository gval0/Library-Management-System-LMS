package com.library.lms.service.search;

import com.library.lms.model.Book;

import java.util.List;

public interface BookSearchService {
    List<Book> searchBooks(String search);
}
