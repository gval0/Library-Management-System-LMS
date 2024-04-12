package com.library.lms.service.processor;

import com.library.lms.model.Transaction;
import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.transaction.TransactionService;
import com.library.lms.service.validator.ValidatorType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookProcessor extends Processor {

    private TransactionService transactionService;

    @Override
    List<ResolverType> getResolvers() {
        return List.of(ResolverType.BOOK_RESOLVER, ResolverType.USER_RESOLVER);
    }

    @Override
    List<ValidatorType> getValidators() {
        return List.of(ValidatorType.BORROW_BOOK_VALIDATOR, ValidatorType.BORROW_USER_VALIDATOR);
    }

    @Override
    public void processTransaction(Transaction transaction) {
        transactionService.borrowBook(transaction);
    }


}
