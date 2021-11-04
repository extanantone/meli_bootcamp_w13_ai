package com.bootcamp.CalCalorias.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NullException.class)
    public ResponseEntity<?> NullException(Exception e){
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


}
