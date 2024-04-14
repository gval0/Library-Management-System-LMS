package com.library.lms.controller.request.book;

import com.library.lms.entity.BookEntity;
import com.library.lms.entity.enums.BookStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String isbn;

    public BookEntity toEntity() {
        return BookEntity.builder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .status(BookStatus.AVAILABLE)
                .build();
    }

}
