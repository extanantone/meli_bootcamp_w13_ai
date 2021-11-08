package com.example.c4_manejo_excep_vivo_p1.exception.handler;

import com.example.c4_manejo_excep_vivo_p1.dto.exception.ErrorDTO;
import com.example.c4_manejo_excep_vivo_p1.exception.DuplicateException;
import com.example.c4_manejo_excep_vivo_p1.exception.NotFoundException;
import com.example.c4_manejo_excep_vivo_p1.model.EntradaBlog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogControllerExceptionHandler
{
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> duplicateExceptionHandler(DuplicateException e)
    {
        ErrorDTO error = new ErrorDTO("Not Accepted - Blog", "The id " + e.getId() + " is duplicated");
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException e)
    {
        ErrorDTO error = new ErrorDTO("Not Found Error- Blog", "The id " + e.getId() + " is not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }
}
