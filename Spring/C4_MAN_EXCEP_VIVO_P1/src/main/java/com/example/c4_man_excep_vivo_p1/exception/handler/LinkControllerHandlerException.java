package com.example.c4_man_excep_vivo_p1.exception.handler;

import com.example.c4_man_excep_vivo_p1.dto.exception.ErrorDTO;
import com.example.c4_man_excep_vivo_p1.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LinkControllerHandlerException
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e)
    {
        ErrorDTO error = new ErrorDTO("ID no valido", "El link no es valido ID:" + e.getLinkId());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
