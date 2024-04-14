package com.library.lms.service.bo;

import com.library.lms.controller.request.book.CreateBookRequest;
import com.library.lms.controller.request.book.UpdateBookRequest;
import com.library.lms.entity.BookEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
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
        return Mapper.getBook(bookRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book not found with id: " + id)));
    }

    public BookEntity getEntityById(Long id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book not found with id: " + id));
    }

    public Book update(Long id, UpdateBookRequest request) {
        bookRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book not found with id: " + id));
        return Mapper.getBook(bookRepo.save(request.toEntity()));
    }

    public void delete(Long id) {
        bookRepo.delete(bookRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.BOOK_NOT_FOUND, "Book not found with id: " + id)));
    }
}
