package com.bootcamp.socialmeli.exceptions;


import com.bootcamp.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> NotFoundException(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = "Not Found";
        }
        return new ResponseEntity<>(
                new ErrorDTO(404, message),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> BadRequestException(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = "Bad Request";
        }
        return new ResponseEntity<>(
                new ErrorDTO(400, message),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = "Method argument not valid\n";
        message += e.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage() + "\n")
                .collect(Collectors.joining());
        return new ResponseEntity<>(
                new ErrorDTO(400, message),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(
                new ErrorDTO(400, message),
                HttpStatus.BAD_REQUEST
        );
    }
}