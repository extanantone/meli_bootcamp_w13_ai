package com.bootcamp.socialmeli.exception.handler;

import com.bootcamp.socialmeli.dto.ErrorDTO;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionUserHandler {

    @ExceptionHandler(NotPossibleOperationException.class)
    public ResponseEntity<ErrorDTO> get(NotPossibleOperationException e){
        return new ResponseEntity<>(
                new ErrorDTO("400", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Exception(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no especificado");
    }
}
