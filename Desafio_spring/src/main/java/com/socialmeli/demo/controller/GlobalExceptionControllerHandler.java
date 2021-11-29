package com.socialmeli.demo.controller;

import com.socialmeli.demo.dto.ErrorDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionControllerHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO methodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        return processFieldErrors(fieldErrors);
    }

    private ErrorDTO processFieldErrors(List<FieldError> fieldErrors){
        ErrorDTO errorDTO = new ErrorDTO(BAD_REQUEST.value(), "validation error");
        for (FieldError fieldError : fieldErrors){
            errorDTO.addFieldErrors(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errorDTO;
    }
}
