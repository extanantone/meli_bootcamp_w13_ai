package com.bootcamp.SocialMeli.Exception.Handler;

import com.bootcamp.SocialMeli.DTO.Errores.ErrorDTO;
import com.bootcamp.SocialMeli.Exception.InvalidSocialException;
import com.bootcamp.SocialMeli.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerSocialMeli {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidSocialException.class)
    public ResponseEntity<?> handleInvalidPost(InvalidSocialException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage()));
    }
}
