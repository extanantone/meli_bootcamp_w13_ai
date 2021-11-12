package com.bootcamp.SocialMeli.exception.handler;

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
                        "ERROR 404",
                        e.getMessage()
                ), HttpStatus.BAD_REQUEST
        );

    }
}
