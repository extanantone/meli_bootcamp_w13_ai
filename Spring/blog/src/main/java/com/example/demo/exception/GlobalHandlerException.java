package com.example.demo.exception;

import com.example.demo.controller.EntradaBlogController;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(assignableTypes = EntradaBlogController.class)
public class GlobalHandlerException {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandlerException(DuplicateException e){
        return new ResponseEntity<>(e, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(){
        return new ResponseEntity<>("todo mal", HttpStatus.BAD_REQUEST);
    }
}
