package com.example.linktracker.exeption;

import com.example.linktracker.dto.GenericExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<GenericExceptionDTO> notFoundExceptionHandler(InvalidURLException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(HttpStatus.NOT_FOUND.value(),e.getMessage()));
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<GenericExceptionDTO> wrongPasswordExceptionHandler(WrongPasswordException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GenericExceptionDTO(HttpStatus.UNAUTHORIZED.value(),e.getMessage()));
    }

    @ExceptionHandler(MissingBodyException.class)
    public ResponseEntity<GenericExceptionDTO> missingBodyExceptionHandler(MissingBodyException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }
}