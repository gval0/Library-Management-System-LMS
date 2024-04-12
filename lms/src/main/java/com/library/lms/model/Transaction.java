package com.library.lms.model;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.TransactionEntity;
import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.TransactionType;

import java.util.Date;

public interface Transaction {

    Long getId();
    Book getBook();
    User getUser();
    TransactionType getType();
    Date getTransactionDate();

    BookEntity getBookEntity();
    UserEntity getUserEntity();

    void updateBook(Book book);

    void updateUser(User user);

    void updateUserEntity(UserEntity userEntity);
    void updateBookEntity(BookEntity bookEntity);
    void updateDate(Date date);

    TransactionEntity getTransactionEntity();
}
