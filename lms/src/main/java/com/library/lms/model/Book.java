package com.library.lms.model;

import com.library.lms.entity.enums.BookStatus;

public interface Book {

    String getTitle();

    String getAuthor();

    String getISBN();

    BookStatus getStatus();

    Long getId();
}
