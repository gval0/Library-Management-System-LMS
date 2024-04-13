package com.library.lms.service.processor;

import com.library.lms.controller.response.Response;
import com.library.lms.model.Transaction;
import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.validator.ValidatorType;

import java.util.List;

public interface Processor {

    List<ResolverType> getResolvers();

    List<ValidatorType> getValidators();

    Response processTransaction(Transaction transaction);

    Response process(Transaction transaction);

}
