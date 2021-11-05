package com.blog.controller;

import com.blog.dto.ExceptionDto;
import com.blog.exception.ExistException;
import com.blog.exception.NotFoundEntryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ExistException.class)
    public ResponseEntity<?> handleExistException(ExistException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(NotFoundEntryException.class)
    public  ResponseEntity<?> handleNotFoundException(NotFoundEntryException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }

}
