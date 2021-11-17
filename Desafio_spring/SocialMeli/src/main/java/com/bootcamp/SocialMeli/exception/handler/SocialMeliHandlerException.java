package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ResponseDTO;
import com.bootcamp.SocialMeli.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliHandlerException {
    @ExceptionHandler(DeniedActionException.class)
    public ResponseEntity<ResponseDTO> getException(DeniedActionException e) {
        return new ResponseEntity<>(
                new ResponseDTO("denied_action", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateIDPostException.class)
    public ResponseEntity<ResponseDTO> getException(DuplicateIDPostException e) {
        return new ResponseEntity<>(
                new ResponseDTO("duplicate_id", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> getException(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ResponseDTO("user_not_found", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}