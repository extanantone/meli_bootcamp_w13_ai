package com.socialmeli.controller;

import com.socialmeli.dto.ErrorDto;
import com.socialmeli.exception.InvalidPostException;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.DateTimeException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidSellerException.class)
    public ResponseEntity<?> handlerIvalidSeller(InvalidSellerException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
    }
    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundUserException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<?> handleInvalidPost(InvalidPostException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<?> handleTime(DateTimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("Invalid date"));
    }
}
