package com.library.lms.service.processor.impl;

import com.library.lms.controller.response.BorrowAndReturnBookResponse;
import com.library.lms.controller.response.Response;
import com.library.lms.model.Transaction;
import com.library.lms.service.processor.TransactionProcessor;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.transaction.TransactionService;
import com.library.lms.service.validator.Validator;
import com.library.lms.service.validator.ValidatorType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class BorrowBookProcessor extends TransactionProcessor {

    private final TransactionService transactionService;

    public BorrowBookProcessor(Map<ResolverType, Resolver> resolverMap, Map<ValidatorType, Validator> validatorMap, TransactionService transactionService) {
        super(resolverMap, validatorMap);
        this.transactionService = transactionService;
    }

    @Override
    public List<ResolverType> getResolvers() {
        return List.of(ResolverType.BOOK_RESOLVER, ResolverType.USER_RESOLVER);
    }

    @Override
    public List<ValidatorType> getValidators() {
        return List.of(ValidatorType.BORROW_BOOK_VALIDATOR, ValidatorType.BORROW_USER_VALIDATOR);
    }

    @Override
    public Response processTransaction(Transaction transaction) {

        Transaction res = transactionService.borrowBook(transaction);

        return BorrowAndReturnBookResponse.builder()
                .transactionId(res.getId())
                .build();

    }


}
