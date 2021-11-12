package com.lgoyenechea.socialmeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserArgumentNotValidException.class)
    public ResponseEntity<Object> userArgumentNotValidException(UserArgumentNotValidException userArgumentNotValidException) {
        Error error = new Error();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(userArgumentNotValidException.getMessage());
        return buildResponseEntity(error);
    }

    private ResponseEntity<Object> buildResponseEntity(Error error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}
