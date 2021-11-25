package com.example.socialmeli.demo.exception;

import com.example.socialmeli.demo.dto.DTOError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FollowingItselfException.class)
    public ResponseEntity<?> followingItselfException(){
        return new ResponseEntity<>("El usuario esta intentando seguirse a si mismo.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(){
        return new ResponseEntity<>("No se ha encontrado al usuario solicitado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<?> vendorNotFoundException(){
        return new ResponseEntity<>("No se ha encontrado al vendedor ingresado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFollowingToUserException.class)
    public ResponseEntity<?> userNotFollowingToUserRequested(){
        return new ResponseEntity<>("El usuario no se encontraba siguiendo al usuario solicitado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFollowingToUser.class)
    public ResponseEntity<?> userAleradyFollowingToUser(){
        return new ResponseEntity<>("El usuario ya se encuentra siguiendo al usuario enviado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<DTOError> handleValidationExceptions(MethodArgumentNotValidException e) {
        DTOError error = new DTOError("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }




}
