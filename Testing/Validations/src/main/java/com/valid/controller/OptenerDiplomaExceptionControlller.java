package com.valid.controller;

import com.valid.dto.ResponseErrorDto;
import com.valid.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class OptenerDiplomaExceptionControlller {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        HashMap<String,String> errors = new HashMap<>();
        e.getFieldErrors().stream().forEach(f->{
            errors.put(f.getField(),f.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handlerStudentNotFound(StudentNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseErrorDto(e.getMessage()));
    }
}
