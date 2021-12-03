package com.student.controller;

import com.student.exceptions.StudentFoundException;
import com.student.exceptions.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(StudentFoundException.class)
    public ResponseEntity<?> handleStudentFount(StudentFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<?> handleStudentNotFound(StudentNotFound e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


}
