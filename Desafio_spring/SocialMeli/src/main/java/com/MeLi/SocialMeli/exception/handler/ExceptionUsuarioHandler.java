package com.MeLi.SocialMeli.exception.handler;

import com.MeLi.SocialMeli.DTO.ErrorNotFoundDTO;
import com.MeLi.SocialMeli.exception.NotFoundCompradorException;
import com.MeLi.SocialMeli.exception.NotFoundVendedorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionUsuarioHandler {

    @ExceptionHandler(NotFoundCompradorException.class)
    public ResponseEntity<ErrorNotFoundDTO> getComprador(NotFoundCompradorException e){
        return new ResponseEntity<>(new ErrorNotFoundDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundVendedorException.class)
    public ResponseEntity<ErrorNotFoundDTO> getVendedor(NotFoundVendedorException e){
        return new ResponseEntity<>(new ErrorNotFoundDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
