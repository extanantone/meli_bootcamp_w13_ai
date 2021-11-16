package com.example.demo.exception.handler;

import com.example.demo.controller.UserController;
import com.example.demo.dtos.exception.ErrorDTO;
import com.example.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e){
        ErrorDTO error = new ErrorDTO("Not Found Exception - User", "The id " + e.getId() + " is incorrect");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
