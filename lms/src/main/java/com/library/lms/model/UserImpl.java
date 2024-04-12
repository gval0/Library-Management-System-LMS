package com.library.lms.model;

import com.library.lms.entity.enums.UserRole;

import java.util.List;


public class UserImpl implements User {

    private Long id;
    private String username;
    private UserRole userRole;
    private List<Book> borrowedBooks;

    private UserImpl() {
    }

    private UserImpl(Long id, String username, UserRole userRole, List<Book> borrowedBooks) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
        this.borrowedBooks = borrowedBooks;
    }

    public UserImpl(Long userId) {
        this.id = userId;
    }

    public static UserImpl of() {
        return new UserImpl();
    }

    public static UserImpl of(Long id, String username, UserRole userRole, List<Book> borrowedBooks) {
        return new UserImpl(id, username, userRole, borrowedBooks);
    }

    public static User of(Long userId) {
        return new UserImpl(userId);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public UserRole getUserRole() {
        return userRole;
    }
}

