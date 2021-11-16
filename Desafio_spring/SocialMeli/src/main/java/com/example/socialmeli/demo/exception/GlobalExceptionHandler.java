package com.example.socialmeli.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FollowingItselfException.class)
    public ResponseEntity<?> followingItselfException(){
        return new ResponseEntity<>("El usuario esta intentando seguirse a si mismo", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(){
        return new ResponseEntity<>("El usuario al cual se intenta identificar no se encuentra registrado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<?> vendorNotFoundException(){
        return new ResponseEntity<>("Se ha registrado un problema al intentar buscar al vendedor seguido por el usuario ingresado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFollowingToUserException.class)
    public ResponseEntity<?> userNotFollowingToUserRequested(){
        return new ResponseEntity<>("El usuario solicitado no se encontraba siguiendo al usuario solicitado", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFollowingToUser.class)
    public ResponseEntity<?> userAleradyFollowingToUser(){
        return new ResponseEntity<>("El usuario solicitado ya se encuentra siguiendo al usuario solicitado", HttpStatus.BAD_REQUEST);
    }




}
