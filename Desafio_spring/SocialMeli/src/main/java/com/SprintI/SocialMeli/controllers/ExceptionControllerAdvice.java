package com.SprintI.SocialMeli.controllers;

import com.SprintI.SocialMeli.exceptions.UserNotFoundException;
import com.SprintI.SocialMeli.dtos.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNotFoundException.class})
    public ErrorDTO handleUserNotFoundException(RuntimeException e) {
        return new ErrorDTO(e.getMessage(), LocalDateTime.now());
    }
}
