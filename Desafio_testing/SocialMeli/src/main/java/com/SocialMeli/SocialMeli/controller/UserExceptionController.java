package com.SocialMeli.SocialMeli.controller;

import com.SocialMeli.SocialMeli.dto.ErrorDTO;
import com.SocialMeli.SocialMeli.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserException.class)
    ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return  new ResponseEntity<>(e.getErrorDTO(), e.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e){
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e){
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        if (e.getMessage().contains("DateTimeParseException")) {
            error.setDescription("El formato de fecha ingresado es inválido. Debe respetarse dd-MM-yyyy.");
        }
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
