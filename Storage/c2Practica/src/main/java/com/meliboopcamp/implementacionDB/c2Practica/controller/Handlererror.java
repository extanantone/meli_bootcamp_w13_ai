package com.meliboopcamp.implementacionDB.c2Practica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handlererror {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception (Exception e){
        e.printStackTrace();

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
