package com.bootcamp.SpringJPA.exception.handler;

import com.bootcamp.SpringJPA.dto.ErrorDTO;
import com.bootcamp.SpringJPA.exception.DuplicateIdException;
import com.bootcamp.SpringJPA.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GeneralExceptionHandler {

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<ErrorDTO> duplicateIdException(DuplicateIdException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getClass().getSimpleName(), ex.getMessage()),
                                    HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDTO> studentNotFoundException(StudentNotFoundException ex){
        return new ResponseEntity<>(new ErrorDTO(ex.getClass().getSimpleName(), ex.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
