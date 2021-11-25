package com.meli.SocialMeli.exception.handle;

import com.meli.SocialMeli.dto.ErrorDTO;
import com.meli.SocialMeli.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionSocialMeliHandle {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e) {
        ErrorDTO error = new ErrorDTO("invalid_parameter", "Error: " + e.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("invalid_parameter", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
