package com.example.demo.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "오픈 API 통신 에러")
public class ClientNoContentRuntimeException extends RuntimeException {

    public ClientNoContentRuntimeException() {
        super(ExceptionMessage.NO_CONTNET.getMessage());
    }
}
