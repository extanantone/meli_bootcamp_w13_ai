package com.example.socialmeli.exceptions.handler;

import com.example.socialmeli.exceptions.SocialMeliException;
import com.example.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(SocialMeliException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO("GeneralError", "Problema interno"),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
