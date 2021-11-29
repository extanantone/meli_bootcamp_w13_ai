package com.bootcamp.SocialMeli.exceptions;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(SameUserException.class)
    public ResponseEntity<?> SameUserException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(IdAlreadyCreatedException.class)
    public ResponseEntity<?> IdAlreadyCreated(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorDTO(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResponseEntity<>(new ErrorDTO("Parámetros incorrectos"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoValidOrderException.class)
    public ResponseEntity<?> NoValidOrderException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
