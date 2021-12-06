package com.bootcamp.StudentProject.exception.handler;

import com.bootcamp.StudentProject.dto.ExceptionResponseDTO;
import com.bootcamp.StudentProject.exception.StudentAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentProjectHandlerException {
    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> getException(StudentAlreadyExistsException e) {
        return new ResponseEntity<>(
                new ExceptionResponseDTO("student_exists", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}