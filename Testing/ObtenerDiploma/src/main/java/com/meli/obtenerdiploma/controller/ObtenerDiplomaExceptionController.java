package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObtenerDiplomaExceptionController {


        @ExceptionHandler(value = { Exception.class })
        public ResponseEntity<Object> handleAnyException(Exception ex) {
            return new ResponseEntity<>(new ErrorDTO(ex.getMessage(),ex.getClass().getCanonicalName()), new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = { RuntimeException.class })
        public ResponseEntity<Object> handleRuntimeExceptions(RuntimeException ex) {
            return new ResponseEntity<>(new ErrorDTO(ex.getMessage(),ex.getClass().getCanonicalName()), new HttpHeaders(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = { MethodArgumentNotValidException.class })
        public ResponseEntity<Object> handleMethodArgumentNotValidExceptions(MethodArgumentNotValidException ex) {
            return new ResponseEntity<>(new ErrorDTO(ex.getBindingResult().getFieldError().getDefaultMessage(),ex.getClass().getCanonicalName()), HttpStatus.NOT_FOUND);
        }


        @ExceptionHandler(value = { HttpMessageNotReadableException.class })
        public ResponseEntity<Object> handleHttpMessageNotReadableExceptions(HttpMessageNotReadableException ex) {
            return new ResponseEntity<>(new ErrorDTO(ex.getMessage(),ex.getClass().getCanonicalName()), new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

