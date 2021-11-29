package com.bootcamp.SocialMeli.exception;

import com.bootcamp.SocialMeli.dto.TextResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyException(Exception ex) {
        return new ResponseEntity<>(new HashMap<>() {{
            put("error_code", "system error");
            put("message", ex.getMessage());
        }}, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeExceptions(RuntimeException ex) {
        return new ResponseEntity<>(new TextResponseDTO(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = { GenericException.class })
    public ResponseEntity<Object> handleOwnExceptions(GenericException ex) {
        return new ResponseEntity<>(new TextResponseDTO(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException ex)
    {
        return new ResponseEntity<>(new TextResponseDTO(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}



