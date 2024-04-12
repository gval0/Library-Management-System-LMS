package com.library.lms.util;

import com.library.lms.service.resolver.BookResolver;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.resolver.UserResolver;
import com.library.lms.service.validator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Beans {

    @Bean
    Map<ResolverType, Resolver> getResolverMap() {

        Map<ResolverType, Resolver> map = new HashMap<>();

        map.put(ResolverType.BOOK_RESOLVER, new BookResolver());
        map.put(ResolverType.USER_RESOLVER, new UserResolver());

        return map;

    }

    @Bean
    Map<ValidatorType, Validator> getValidatorMap() {

        Map<ValidatorType, Validator> map = new HashMap<>();

        map.put(ValidatorType.BORROW_BOOK_VALIDATOR, new BorrowBookValidator());
        map.put(ValidatorType.BORROW_USER_VALIDATOR, new BorrowUserValidator());
        map.put(ValidatorType.RETURN_BOOK_VALIDATOR, new ReturnBookValidator());
        map.put(ValidatorType.RETURN_USER_VALIDATOR, new ReturnUserValidator());

        return map;

    }
}
