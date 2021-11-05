package com.example.bootcamp.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandlerException(){

        return new ResponseEntity<>("todo mal", HttpStatus.I_AM_A_TEAPOT);

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(){

        return new ResponseEntity<>("todo mal", HttpStatus.I_AM_A_TEAPOT);

    }

}
