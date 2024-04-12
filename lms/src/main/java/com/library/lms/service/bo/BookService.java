package com.library.lms.service.bo;

import com.library.lms.controller.request.CreateBookRequest;
import com.library.lms.controller.request.UpdateBookRequest;
import com.library.lms.model.Book;

public interface BookService {
    Book create(CreateBookRequest request);
    Book getById(Long id);
    Book update(Long id, UpdateBookRequest request);
    void delete(Long id);
}
