package com.example.demo.exception.handler;

import com.example.demo.controller.EntradaBlogController;
import com.example.demo.dtos.exception.ErrorDTO;
import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(assignableTypes = EntradaBlogController.class)
public class BlogControllerHandlerException {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandlerException(DuplicateException e){
        return new ResponseEntity<>(e, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        ErrorDTO error = new ErrorDTO("Not Found Exception - Blog", "The id " + e.getId() + " is incorrect");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
