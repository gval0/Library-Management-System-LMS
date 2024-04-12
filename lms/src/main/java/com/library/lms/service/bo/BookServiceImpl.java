package com.library.lms.service.bo;

import com.library.lms.controller.request.CreateBookRequest;
import com.library.lms.controller.request.UpdateBookRequest;
import com.library.lms.entity.BookEntity;
import com.library.lms.model.Book;
import com.library.lms.util.Mapper;
import com.library.lms.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public Book create(CreateBookRequest request) {
        return Mapper.getBook(bookRepo.save(request.toEntity()));
    }

    public Book getById(Long id) {
        return Mapper.getBook(bookRepo.findById(id).orElseThrow());
    }

    public Book update(Long id, UpdateBookRequest request) {
        // todo custom exception
        BookEntity oldBook = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return Mapper.getBook(bookRepo.save(request.toEntity()));
    }

    public void delete(Long id) {
        bookRepo.delete(bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found")));
    }
}
