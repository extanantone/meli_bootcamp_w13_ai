package com.bootcamp.c1p1asincimpbd.exception.handler;

import com.bootcamp.c1p1asincimpbd.exception.StudentExistException;
import com.bootcamp.c1p1asincimpbd.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentHandlerException {
    @ExceptionHandler(StudentExistException.class)
    public ResponseEntity<?> handleStudentFoundException(StudentExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
