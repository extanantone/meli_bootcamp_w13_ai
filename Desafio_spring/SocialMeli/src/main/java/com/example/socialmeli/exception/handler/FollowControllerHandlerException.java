package com.example.socialmeli.exception.handler;

import com.example.socialmeli.dto.exception.ErrorDTO;
import com.example.socialmeli.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FollowControllerHandlerException
{
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e)
    {
        ErrorDTO error = new ErrorDTO("Acción no valida", "Error: " + e.getMsg());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
