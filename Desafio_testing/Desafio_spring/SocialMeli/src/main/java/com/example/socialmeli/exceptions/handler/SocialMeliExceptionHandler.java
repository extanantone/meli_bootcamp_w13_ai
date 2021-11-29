package com.example.socialmeli.exceptions.handler;

import com.example.socialmeli.exceptions.SocialMeliException;
import com.example.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(SocialMeliException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO("GeneralError", "Problema interno"),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e){
        e.printStackTrace();

        return new ResponseEntity<>(new ErrorDTO("Error de validacion",e.getBindingResult().getFieldError().getDefaultMessage()),HttpStatus.BAD_REQUEST);
    }
}
