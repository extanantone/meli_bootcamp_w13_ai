package com.desafiospring.demo.exception.handle;

import com.desafiospring.demo.DTO.ErrorDTO;
import com.desafiospring.demo.exception.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class UserHandle {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO>FollowersNotFound(UserNotFoundException e) {
         ErrorDTO errorDto = new ErrorDTO(HttpStatus.BAD_GATEWAY.toString(), e.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.ACCEPTED);
    }
}
