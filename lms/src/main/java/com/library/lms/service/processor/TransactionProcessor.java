package com.library.lms.service.processor;

import com.library.lms.controller.response.Response;
import com.library.lms.model.Transaction;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.service.resolver.ResolverType;

import com.library.lms.service.validator.Validator;
import com.library.lms.service.validator.ValidatorType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public abstract class TransactionProcessor implements Processor {


    private final Map<ResolverType, Resolver> resolverMap;

    private final Map<ValidatorType, Validator> validatorMap;

    public Response process(Transaction transaction) {
        getResolvers().forEach(resolverType -> resolverMap.get(resolverType).resolve(transaction));
        getValidators().forEach(validatorType -> validatorMap.get(validatorType).validate(transaction));
        return processTransaction(transaction);
    }
}
