package com.library.lms.controller.response;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Response {

    @NotNull
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private UserRole userRole;

    @NotNull
    private List<BookEntity> borrowedBooks;

}
