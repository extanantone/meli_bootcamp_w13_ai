package com.bootcamp.socialmeli.exception.handler;

import com.bootcamp.socialmeli.dto.ErrorDTO;
import com.bootcamp.socialmeli.dto.ValidFieldErrorDTO;
import com.bootcamp.socialmeli.exception.NotPossibleOperationException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionUserHandler {

    @ExceptionHandler(NotPossibleOperationException.class)
    public ResponseEntity<ErrorDTO> get(NotPossibleOperationException e){
        return new ResponseEntity<>(
                new ErrorDTO("Not possible operation", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> error(
            MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();

        List<ValidFieldErrorDTO> validList = new ArrayList<>();

        for (FieldError fe : errors) {
            ValidFieldErrorDTO valid = new ValidFieldErrorDTO( fe.getField(), fe.getDefaultMessage() );
            validList.add( valid );
        }

        return new ResponseEntity<>(
                new ErrorDTO(
                        "validation_error",
                        "Some data are invalid",
                        validList),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> Exception(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no especificado: " + e.getMessage());
    }
}
