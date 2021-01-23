package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice(basePackages = "com.example.demo.web")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ClientAuthRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResponse handleClientAuthRuntimeException(Exception e, WebRequest request) {

        log.error("handleOpenApiRuntimeException", e);

        return CommonResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(value = ClientNoContentRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResponse handleClientNoContentRuntimeException(Exception e, WebRequest request) {

        log.error("handleClientNoContentRuntimeException", e);

        return CommonResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NO_CONTENT.value())
                .build();
    }
}
