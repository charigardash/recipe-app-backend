package com.app.food.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException customException) {
        return ResponseEntity.status(customException.getHttpStatus()).body(customException.getMessage());
    }
}
