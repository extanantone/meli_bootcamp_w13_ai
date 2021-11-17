package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.GenericExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GenericExceptionDTO> userNotFoundExceptionHandler(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(HttpStatus.NOT_FOUND.value(),e.getMessage()));
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<GenericExceptionDTO> internalErrorExceptionHandler(InternalServerError e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<GenericExceptionDTO> postNotFoundExceptionHandler(PostNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(HttpStatus.NOT_FOUND.value(),e.getMessage()));
    }

    @ExceptionHandler(MissingBodyException.class)
    public ResponseEntity<GenericExceptionDTO> missingBodyExceptionHandler(MissingBodyException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(MissingBodyAttributeException.class)
    public ResponseEntity<GenericExceptionDTO> missingBodyAttributeExceptionHandler(MissingBodyAttributeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericExceptionDTO> badRequestExceptionHandler(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }
}
