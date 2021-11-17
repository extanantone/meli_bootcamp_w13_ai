package com.example.socialmeli.exceptions;

import com.example.socialmeli.dto.EmptyJsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNoFound.class)
    public ResponseEntity<?> UserNoFound(Exception e){
        EmptyJsonResponse empty = new EmptyJsonResponse();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empty);
    }

    @ExceptionHandler(ErrorInOperation.class)
    public ResponseEntity<?> ErrorInOperation(Exception e){
        EmptyJsonResponse empty = new EmptyJsonResponse();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empty);
    }
    @ExceptionHandler(PostAlreadyCreated.class)
    public ResponseEntity<?> PostAlreadyCreated(Exception e){
        EmptyJsonResponse empty = new EmptyJsonResponse();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empty);
    }


}
