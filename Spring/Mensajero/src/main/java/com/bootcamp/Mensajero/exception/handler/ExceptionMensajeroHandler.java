package com.bootcamp.Mensajero.exception.handler;

import com.bootcamp.Mensajero.dto.ErrorDTO;
import com.bootcamp.Mensajero.exception.MensajeroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMensajeroHandler {

    @ExceptionHandler(MensajeroNotFoundException.class)
    public ResponseEntity<ErrorDTO> get(MensajeroNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_mensajero",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND );

    }
}
