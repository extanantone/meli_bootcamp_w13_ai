package com.app.controller;

import com.app.exception.NotFoundItem;
import com.app.exception.PalomaException;
import com.app.exception.TelefonoException;
import com.app.exception.TelegrafoException;
import com.app.model.TelefonoCelular;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MessengerExceptionController {

    @ExceptionHandler(NotFoundItem.class)
    public ResponseEntity<?> handlerNotFound(NotFoundItem e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PalomaException.class)
    public ResponseEntity<?> handlerPaloma(PalomaException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TelefonoException.class)
    public ResponseEntity<?> handlerCel(TelefonoException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(TelegrafoException.class)
    public ResponseEntity<?> handlerTelegrafo(TelegrafoException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


}
