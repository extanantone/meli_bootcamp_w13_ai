

package com.example.socialmeli.exceptions;


import com.example.socialmeli.DTO.ErrorDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Error.class)
    public ResponseEntity<ErrorDTO> get(Error e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );

    }
}