package com.library.lms.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.lms.entity.enums.TransactionType;
import com.library.lms.model.Transaction;
import com.library.lms.model.TransactionImpl;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBookRequest {

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    @JsonIgnore
    public Transaction getTransaction(){
        return TransactionImpl.of(bookId, userId);
    }

}
