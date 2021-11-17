package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import com.bootcamp.SocialMeli.exception.PostAlreadyExistsException;
import com.bootcamp.SocialMeli.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IPostExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    ResponseEntity<ErrorDTO> postNotFoundHandler(PostNotFoundException e);

    @ExceptionHandler(PostAlreadyExistsException.class)
    ResponseEntity<ErrorDTO> postAlreadyExistsHandler(PostAlreadyExistsException e);
}
