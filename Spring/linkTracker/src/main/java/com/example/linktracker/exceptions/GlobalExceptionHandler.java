package com.example.linktracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(Exception e) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundRequest(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedRequest.class)
    public  ResponseEntity<?> unauthorizedRequest(Exception e) {
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
