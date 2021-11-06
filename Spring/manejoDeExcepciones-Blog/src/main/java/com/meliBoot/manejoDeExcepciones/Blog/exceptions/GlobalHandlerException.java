package com.meliBoot.manejoDeExcepciones.Blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandleException(){

        return new ResponseEntity<>("Todo fuera de estado", HttpStatus.I_AM_A_TEAPOT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> duplicateHandleException2(){

        return new ResponseEntity<>("Todo fuera de estado", HttpStatus.BAD_REQUEST);
    }

}
