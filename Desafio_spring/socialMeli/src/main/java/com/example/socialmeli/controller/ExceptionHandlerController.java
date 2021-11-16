package com.example.socialmeli.controller;

import com.example.socialmeli.dto.ErrorDto;
import com.example.socialmeli.exception.BadBodyRequestException;
import com.example.socialmeli.exception.BadParamsRequestException;
import com.example.socialmeli.exception.FollowException;
import com.example.socialmeli.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionHandlerController {

    @ExceptionHandler(BadBodyRequestException.class)
    public ResponseEntity<ErrorDto> invalidBody (BadBodyRequestException e){
        ErrorDto errorResponse = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadParamsRequestException.class)
    public ResponseEntity<ErrorDto> invalidParams (BadParamsRequestException e){
        ErrorDto errorResponse = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDto> followError (FollowException e){
        ErrorDto errorResponse = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ErrorDto> userNotExist (UserNotExistException e){
        ErrorDto errorResponse = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
