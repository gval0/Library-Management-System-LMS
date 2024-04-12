package com.library.lms.model;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.TransactionEntity;
import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.TransactionType;

import java.util.Date;

public class TransactionImpl implements Transaction {

    private Long id;

    private Book book;

    private User user;

    private TransactionType type;

    private Date date;

    private UserEntity userEntity;

    private BookEntity bookEntity;

    private TransactionImpl() {
    }

    private TransactionImpl(Long id, Book book, User user, TransactionType type, Date date) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.type = type;
        this.date = date;
    }

    public TransactionImpl(Long bookId, Long userId, TransactionType type) {
        this.book = BookImpl.of(bookId);
        this.user = UserImpl.of(userId);
        this.type = type;
    }

    public static TransactionImpl of() {
        return new TransactionImpl();
    }

    public static TransactionImpl of(Long id, Book book, User user, TransactionType type, Date date) {
        return new TransactionImpl(id, book, user, type, date);
    }

    public static TransactionImpl of(Long bookId, Long userId, TransactionType type) {
        return new TransactionImpl(bookId, userId, type);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Book getBook() {
        return book;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public TransactionType getType() {
        return type;
    }

    @Override
    public Date getTransactionDate() {
        return date;
    }

    @Override
    public BookEntity getBookEntity() {
        return bookEntity;
    }

    @Override
    public UserEntity getUserEntity() {
        return userEntity;
    }

    @Override
    public void updateBook(Book book) {
        this.book = book;
    }

    @Override
    public void updateUser(User user) {
        this.user = user;
    }

    @Override
    public void updateUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public void updateBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    @Override
    public void updateDate(Date date) {
        this.date = date;
    }

    @Override
    public TransactionEntity getTransactionEntity() {
        return null;
    }
}
