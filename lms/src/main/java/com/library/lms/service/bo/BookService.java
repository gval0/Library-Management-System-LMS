package com.library.lms.service.bo;

import com.library.lms.controller.request.book.CreateBookRequest;
import com.library.lms.controller.request.book.UpdateBookRequest;
import com.library.lms.entity.BookEntity;
import com.library.lms.model.Book;

public interface BookService {
    Book create(CreateBookRequest request);

    Book getById(Long id);

    BookEntity getEntityById(Long id);

    Book update(Long id, UpdateBookRequest request);

    void delete(Long id);
}
