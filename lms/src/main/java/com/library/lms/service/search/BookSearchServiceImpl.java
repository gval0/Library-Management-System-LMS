package com.library.lms.service.search;

import com.library.lms.entity.BookEntity;
import com.library.lms.model.Book;
import com.library.lms.repo.BookRepo;
import com.library.lms.util.BookSpecification;
import com.library.lms.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {

    private final BookRepo bookRepo;

    @Override
    public List<Book> searchBooks(String search) {
        final Specification<BookEntity> specification = BookSpecification.searchBook(search);
        final List<BookEntity> books = bookRepo.findAll(specification);

        return (books != null) ? books.stream().map(Mapper::getBook).collect(Collectors.toList()) : List.of();

    }
}
