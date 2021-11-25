package com.example.socialmeli.exceptions.handler;

import com.example.socialmeli.exceptions.SocialMeliException;
import com.example.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(SocialMeliException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

/*    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO("GeneralError", "Problema interno"),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }*/

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes2(MethodArgumentTypeMismatchException exception){
        ErrorDTO error =  new ErrorDTO();
        error.setName("algo");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Payload's Field Not Valid Exception");
        errorDTO.setDescription("There are some fields that don't respect validations");

        return new ResponseEntity<>(errorDTO, HttpStatus.I_AM_A_TEAPOT);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(ConstraintViolationException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Payload's Field Not Valid Exception");
        errorDTO.setDescription("There are some fields that don't respect validations");

        return new ResponseEntity<>(errorDTO, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(HttpMessageNotReadableException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Payload's Field Not Valid Exception");
        errorDTO.setDescription("There are some fields that don't respect validations");
        System.out.println(exception.getLocalizedMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.I_AM_A_TEAPOT);
    }
}
