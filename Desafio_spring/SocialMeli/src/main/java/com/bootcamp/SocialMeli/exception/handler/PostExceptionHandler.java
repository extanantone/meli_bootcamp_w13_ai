package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import com.bootcamp.SocialMeli.exception.PostAlreadyExistsException;
import com.bootcamp.SocialMeli.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> postNotFoundHandler(PostNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "post_not_found",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND );

    }

    @ExceptionHandler(PostAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> postAlreadyExistsHandler(PostAlreadyExistsException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "post_already_exists",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
}

