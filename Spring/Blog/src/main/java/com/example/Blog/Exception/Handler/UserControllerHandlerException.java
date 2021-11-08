package com.example.Blog.Exception.Handler;

import com.example.Blog.Controller.UserController;
import com.example.Blog.DTO.Exception.ErrorDTO;
import com.example.Blog.Exception.NotFoundException;
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
