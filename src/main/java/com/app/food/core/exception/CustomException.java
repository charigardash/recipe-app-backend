package com.app.food.core.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    public CustomException(HttpStatus status, String message) {
        super(message);
        this.httpStatus = status;
    }

    public CustomException(HttpStatus status, String message, Throwable throwable) {
        super(message, throwable);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
