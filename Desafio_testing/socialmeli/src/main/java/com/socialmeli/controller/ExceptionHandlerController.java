package com.socialmeli.controller;

import com.socialmeli.dto.ErrorDto;
import com.socialmeli.exception.InvalidPostException;
import com.socialmeli.exception.InvalidSellerException;
import com.socialmeli.exception.InvalidUserException;
import com.socialmeli.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidSellerException.class)
    public ResponseEntity<?> handlerIvalidSeller(InvalidSellerException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
    }
    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundUserException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<?> handleInvalidPost(InvalidPostException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<?> handleTime(DateTimeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("Invalid date"));
    }

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<?> handlerInvalidUser(InvalidUserException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handlerValidations(ConstraintViolationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> hadleMethodInvalidArgument(MethodArgumentNotValidException e){
        HashMap<String,String> map = new HashMap<>();
        e.getFieldErrors().forEach(i->{
            map.put(i.getField(),i.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);

    }

}
