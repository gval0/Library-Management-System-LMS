package com.library.lms.model;


import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.BookStatus;

public class BookImpl implements Book {
    private Long id;
    private String title;
    private String author;
    private String ISBN;
    private BookStatus status;
    private UserEntity currentUser;

    private BookImpl() {
    }

    private BookImpl(Long id, String title, String author, String isbn, BookStatus status, UserEntity currentUser) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = isbn;
        this.status = status;
        this.currentUser = currentUser;
    }

    public BookImpl(Long id) {
        this.id = id;
    }

    public BookImpl(String title, String author, String isbn, BookStatus status, UserEntity currentUser) {
        this.title = title;
        this.author = author;
        this.ISBN = isbn;
        this.status = status;
        this.currentUser = currentUser;
    }

    public static BookImpl of(){
        return new BookImpl();
    }

    public static BookImpl of(String title, String author, String isbn, BookStatus status, UserEntity currentUser){
        return new BookImpl(title, author, isbn, status, currentUser);
    }

    public static Book of(Long bookId) {
        return new BookImpl(bookId);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public BookStatus getStatus() {
        return status;
    }

    @Override
    public Long getId() {
        return id;
    }
}
