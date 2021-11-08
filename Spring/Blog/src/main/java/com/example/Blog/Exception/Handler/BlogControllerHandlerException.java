package com.example.Blog.Exception.Handler;

import com.example.Blog.Controller.EntradaBlogController;
import com.example.Blog.DTO.Exception.ErrorDTO;
import com.example.Blog.Exception.DuplicateException;
import com.example.Blog.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = EntradaBlogController.class)
public class BlogControllerHandlerException {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateHandlerException(DuplicateException e){
        return new ResponseEntity<>(e, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        ErrorDTO error = new ErrorDTO("Not Found Exception - Blog", "The id " + e.getId() + " is incorrect");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
