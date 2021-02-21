package com.example.demo.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "오픈 API 통신 에러")
@NoArgsConstructor
public class ClientAuthRuntimeException extends RuntimeException {

    public ClientAuthRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }

    public ClientAuthRuntimeException(String message) {
        super(message);
    }
}
