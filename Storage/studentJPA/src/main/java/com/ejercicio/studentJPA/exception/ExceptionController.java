package com.ejercicio.studentJPA.exception;

import com.ejercicio.studentJPA.dto.MensajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<?>userAlreadyExistsHandler(UserAlreadyExistsException e){
        return new ResponseEntity<>(new MensajeDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
