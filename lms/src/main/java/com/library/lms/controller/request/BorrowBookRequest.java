package com.library.lms.controller.request;

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
public class BorrowBookRequest {

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    // todo transaction entity

    public Transaction getTransaction(){
        return TransactionImpl.of(bookId, userId, TransactionType.BORROW);
    }
}
