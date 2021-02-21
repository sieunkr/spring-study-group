package com.example.demo.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "오픈 API 통신 에러")
@NoArgsConstructor
public class ClientBadRequestRuntimeException extends RuntimeException {

    public ClientBadRequestRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }

    public ClientBadRequestRuntimeException(String message) {
        super(message);
    }
}
