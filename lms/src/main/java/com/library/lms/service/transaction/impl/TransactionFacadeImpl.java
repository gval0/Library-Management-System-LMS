package com.library.lms.service.transaction.impl;

import com.library.lms.controller.request.BorrowBookRequest;
import com.library.lms.controller.request.ReturnBookRequest;
import com.library.lms.controller.response.Response;
import com.library.lms.service.processor.Processor;
import com.library.lms.service.processor.ProcessorType;
import com.library.lms.service.transaction.TransactionFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionFacadeImpl implements TransactionFacade {

    private final Map<ProcessorType, Processor> processorMap;

    @Override
    public Response borrowBook(BorrowBookRequest request) {
        return processorMap.get(ProcessorType.BORROW_BOOK_PROCESSOR).process(request.getTransaction());
    }

    @Override
    public Response returnBook(ReturnBookRequest request) {
        return processorMap.get(ProcessorType.RETURN_BOOK_PROCESSOR).process(request.getTransaction());
    }
}
