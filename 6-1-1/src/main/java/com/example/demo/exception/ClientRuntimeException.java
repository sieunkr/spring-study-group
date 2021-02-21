package com.example.demo.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "오픈 API 통신 에러")
@NoArgsConstructor
public class ClientRuntimeException extends RuntimeException {

    public ClientRuntimeException(ExceptionMessage message) {
        super(message.getMessage());
    }

    public ClientRuntimeException(String message) {
        super(message);
    }
}
