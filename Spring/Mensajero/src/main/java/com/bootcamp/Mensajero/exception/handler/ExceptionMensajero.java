package com.bootcamp.Mensajero.exception.handler;

import com.bootcamp.Mensajero.dto.ErrorDto;
import com.bootcamp.Mensajero.exception.NotFoundMensajero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMensajero {
    @ExceptionHandler(NotFoundMensajero.class)
    public ResponseEntity<ErrorDto> get(NotFoundMensajero e){
        return new ResponseEntity<>(new ErrorDto("not_found_mensajero", e.getMessage()),HttpStatus.NOT_FOUND);
    }
}
