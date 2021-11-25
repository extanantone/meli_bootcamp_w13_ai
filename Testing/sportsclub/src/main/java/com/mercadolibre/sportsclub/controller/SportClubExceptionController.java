package com.mercadolibre.sportsclub.controller;

import com.mercadolibre.sportsclub.exception.SportClubException;
import com.mercadolibre.sportsclub.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SportClubExceptionController {

    @ExceptionHandler(SportClubException.class)
    ResponseEntity<ErrorDTO> handleGlobalExceptions(SportClubException ex) {
        return new ResponseEntity<>(ex.getError(), ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
