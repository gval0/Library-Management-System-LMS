package com.library.lms.util;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.TransactionEntity;
import com.library.lms.entity.UserEntity;
import com.library.lms.model.*;

import java.util.List;

public class Mapper {

    public static Book getBook(BookEntity bookEntity) {

        return BookImpl.of(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getIsbn(),
                bookEntity.getStatus(),
                bookEntity.getUser());

    }

    public static User getUser(UserEntity userEntity) {

        return UserImpl.of(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getUserRole(),
                userEntity.getBorrowedBooks() != null ? userEntity.getBorrowedBooks().stream().map(Mapper::getBook).toList() : List.of(BookImpl.of(22222L)));
    }

    public static Transaction getTransaction(TransactionEntity transactionEntity) {

        return TransactionImpl.of(
                transactionEntity.getId(),
                getBook(transactionEntity.getBook()),
                getUser(transactionEntity.getUser()),
                transactionEntity.getType(),
                transactionEntity.getDate());

    }

}
