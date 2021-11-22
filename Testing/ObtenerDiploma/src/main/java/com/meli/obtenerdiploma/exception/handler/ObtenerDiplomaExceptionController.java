package com.meli.obtenerdiploma.exception.handler;

import com.meli.obtenerdiploma.dto.exception.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ObtenerDiplomaExceptionController
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex)
    {//ex.getFieldError().getField() + " : " +ex.getFieldError().getDefaultMessage());
        ErrorDTO errorDTO = new ErrorDTO("MethodArgumentNotValidException","Not Valid" , ex.getFieldErrors().stream().map(x -> (x.getField() + " : " + x.getDefaultMessage())).collect(Collectors.toList()));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex)
    {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
