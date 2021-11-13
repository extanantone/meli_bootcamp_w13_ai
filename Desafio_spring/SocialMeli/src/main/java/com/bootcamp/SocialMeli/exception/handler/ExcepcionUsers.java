package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.exception.DuplicateIdException;
import com.bootcamp.SocialMeli.exception.NotFoundExceptionUsers;
import com.bootcamp.SocialMeli.exception.exceptiondto.ErrorUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionUsers {

    @ExceptionHandler(NotFoundExceptionUsers.class)
    public ResponseEntity<ErrorUserDTO> get(NotFoundExceptionUsers e){

        return new ResponseEntity<>(
                new ErrorUserDTO(
                        "ERROR "+e.hashCode(),
                        e.getMessage()
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<ErrorUserDTO> get(DuplicateIdException e){

        return new ResponseEntity<>(
                new ErrorUserDTO(
                        "ERROR "+e.hashCode(),
                        e.getMessage()
                ), HttpStatus.BAD_REQUEST
        );
    }
}
