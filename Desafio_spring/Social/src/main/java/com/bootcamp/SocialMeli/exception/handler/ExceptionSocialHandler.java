package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import com.bootcamp.SocialMeli.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionSocialHandler {
    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundUserException e){
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_id",
                        e.getMessage() ), HttpStatus.NOT_FOUND);

    }

}
