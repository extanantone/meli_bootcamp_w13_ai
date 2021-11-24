package com.bootcamp.Mensajero.exception.handler;

import com.bootcamp.Mensajero.dto.ErrorDTO;
import com.bootcamp.Mensajero.exception.NotFoundMensajeroException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMensajeroHandler {

    @ExceptionHandler(NotFoundMensajeroException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundMensajeroException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_mensajero",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND );

    }
}
