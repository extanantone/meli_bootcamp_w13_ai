package com.mercadolibre.socialmeli.exception.handler;

import com.mercadolibre.socialmeli.exception.FollowException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.exception.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionUserHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundException e){
        return new ResponseEntity<>(
                new ErrorDTO("User Not Found",
                        e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDTO> get(FollowException e){
        return new ResponseEntity<>(
                new ErrorDTO("Invalid User",
                        e.getMessage()), HttpStatus.BAD_REQUEST
        );
    }
}
