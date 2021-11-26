package com.example.socialmeli.exception.handler;

import com.example.socialmeli.dto.ErrorDTO;
import com.example.socialmeli.exception.PostIdNotFoundException;
import com.example.socialmeli.exception.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFound (UserIdNotFoundException e) {
        ErrorDTO error = new ErrorDTO("User_ID_not_found", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> postNotFound (PostIdNotFoundException e) {
        ErrorDTO error = new ErrorDTO("Post_ID_not_found", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
