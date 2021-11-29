package com.mercadolibre.socialmeli.exception.handler;

import com.mercadolibre.socialmeli.exception.FollowException;
import com.mercadolibre.socialmeli.exception.NotFoundException;
import com.mercadolibre.socialmeli.exception.SellersFollowException;
import com.mercadolibre.socialmeli.exception.DuplicateException;
import com.mercadolibre.socialmeli.exception.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ControllerAdviceUser {
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
                new ErrorDTO("FollowException",
                        e.getMessage()), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ErrorDTO("MethodArgumentNotValidException",
                Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ErrorDTO("HttpMessageNotReadableException", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorDTO> userDuplicateException(DuplicateException e, int id){
        return new ResponseEntity<>(new ErrorDTO("User with id " + id + " is already registered", e.getMessage()),
                HttpStatus.NOT_ACCEPTABLE
        );
    }

    @ExceptionHandler(SellersFollowException.class)
    public ResponseEntity<ErrorDTO> sellersNotFoundException(SellersFollowException e){
        return new ResponseEntity<>(new ErrorDTO("Sellers Follow Not Found Exception", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
