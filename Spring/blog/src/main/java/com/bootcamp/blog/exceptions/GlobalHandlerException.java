package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandlerException {

    @ExceptionHandler(DuplicatedBlogException.class)
    public ResponseEntity<?> duplicatedBlogException(Exception e){
        return new ResponseEntity<>(new ExceptionDTO("ERROR", e.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return new ResponseEntity<>(new ExceptionDTO("ERROR", e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
