package com.library.lms.service.processor;

import com.library.lms.model.Transaction;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.service.resolver.ResolverType;

import com.library.lms.service.validator.Validator;
import com.library.lms.service.validator.ValidatorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public abstract class Processor {

    @Autowired
    private Map<ResolverType, Resolver> resolverMap;

    @Autowired
    private Map<ValidatorType, Validator> validatorMap;

    abstract List<ResolverType> getResolvers();

    abstract List<ValidatorType> getValidators();

    abstract void processTransaction(Transaction transaction);

    public Transaction process(Transaction transaction) {
        getResolvers().forEach(resolverType -> resolverMap.get(resolverType).resolve(transaction));
        getValidators().forEach(validatorType -> validatorMap.get(validatorType).validate(transaction));
        processTransaction(transaction);
        return transaction;
    }
}
