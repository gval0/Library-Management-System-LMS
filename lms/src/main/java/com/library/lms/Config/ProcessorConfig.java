package com.library.lms.Config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.library.lms.service.bo.BookService;
import com.library.lms.service.bo.UserService;
import com.library.lms.service.processor.Processor;
import com.library.lms.service.processor.ProcessorType;
import com.library.lms.service.processor.impl.BorrowBookProcessor;
import com.library.lms.service.processor.impl.ReturnBookProcessor;
import com.library.lms.service.resolver.impl.BookResolver;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.service.resolver.ResolverType;
import com.library.lms.service.resolver.impl.UserResolver;
import com.library.lms.service.transaction.TransactionService;
import com.library.lms.service.validator.*;
import com.library.lms.service.validator.impl.BorrowBookValidator;
import com.library.lms.service.validator.impl.BorrowUserValidator;
import com.library.lms.service.validator.impl.ReturnBookValidator;
import com.library.lms.service.validator.impl.ReturnUserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ProcessorConfig {

    private final BookService bookService;
    private final UserService userService;
    private final TransactionService transactionService;


    @Bean
    Map<ResolverType, Resolver> getResolverMap() {

        Map<ResolverType, Resolver> map = new HashMap<>();

        map.put(ResolverType.BOOK_RESOLVER, new BookResolver(bookService));
        map.put(ResolverType.USER_RESOLVER, new UserResolver(userService));

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

    @Bean
    Map<ProcessorType, Processor> getProcessorMap() {

        Map<ProcessorType, Processor> map = new HashMap<>();

        map.put(ProcessorType.BORROW_BOOK_PROCESSOR, new BorrowBookProcessor(getResolverMap(), getValidatorMap(), transactionService));
        map.put(ProcessorType.RETURN_BOOK_PROCESSOR, new ReturnBookProcessor(getResolverMap(), getValidatorMap(), transactionService));

        return map;

    }
}
