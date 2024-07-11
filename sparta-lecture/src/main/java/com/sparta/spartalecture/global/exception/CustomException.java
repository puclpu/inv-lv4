package com.sparta.spartalecture.global.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final HttpStatus status;

    public CustomException (CustomExceptionCode code) {
        this(code.getStatus(), code.getMessage());
    }

    public CustomException (HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
