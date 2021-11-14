package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.response.ErrorDTO;
import com.bootcamp.socialmeli.exception.UserException.NotFoundUsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionSocialMeliHandler {

    @ExceptionHandler(NotFoundUsuarioException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundUsuarioException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: not_found_user",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND );

    }
}
