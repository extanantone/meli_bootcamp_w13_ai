package com.example.socialmeli.exceptions.handler;

import com.example.socialmeli.exceptions.SocialMeliException;
import com.example.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(Exception ex){
        ex.printStackTrace();
        ErrorDTO errorDTO = new ErrorDTO("GeneralError", "Problema interno");
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex) {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("MethodArgumentNotValidException");
        errorDTO.setDescription("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception.getFieldErrors().forEach( e -> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            errors.compute(field, ($, l) ->
                    new ArrayList<>(){
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(msg);
                        }
                    }
            );
        });
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }


}
