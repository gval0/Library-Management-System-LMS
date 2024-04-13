package com.library.lms.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInternalException(InternalException ex) {
        return  ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(ErrorResponse.builder()
                .code(ex.getReason().getReasonCode())
                .message(ex.getMessage())
                .reason(ex.getReason())
                .build());
    }

}
