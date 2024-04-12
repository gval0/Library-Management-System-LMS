package com.library.lms.service.processor;

import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.validator.ValidatorType;

import java.util.List;

public class ReturnBookProcessor implements Processor {

    @Override
    List<ResolverType> getResolvers() {
        return List.of(ResolverType.BOOK_RESOLVER, ResolverType.USER_RESOLVER);
    }

    @Override
    List<ValidatorType> getValidators() {
        return List.of(ValidatorType.RETURN_BOOK_VALIDATOR, ValidatorType.RETURN_USER_VALIDATOR);
    }


}
