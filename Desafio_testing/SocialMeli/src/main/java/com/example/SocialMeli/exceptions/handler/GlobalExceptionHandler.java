package com.example.SocialMeli.exceptions.handler;

import com.example.SocialMeli.dto.error.ErrorDto;
import com.example.SocialMeli.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDto> handleGlobalException(SocialMeliException e){
        //e.printStackTrace();
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(MissingFieldsException.class)
    public ResponseEntity<?> MissingFieldsException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<?> validationData(MethodArgumentNotValidException e){
        ErrorDto error = new ErrorDto();
        error.setDescription(e.getAllErrors().toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
