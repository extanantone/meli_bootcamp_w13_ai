package com.Bootcamp.C4P1EJ1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandlerException(DuplicateException e) {
        return new ResponseEntity<>(e.getMensajeError(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException() {
        return new ResponseEntity<>("¡Error! No existe ese ID.", HttpStatus.CONFLICT);
    }
}
