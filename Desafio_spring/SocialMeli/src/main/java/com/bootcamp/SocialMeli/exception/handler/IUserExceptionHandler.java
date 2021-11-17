package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import com.bootcamp.SocialMeli.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface IUserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorDTO> userNotFoundHandler(UserNotFoundException e);

    @ExceptionHandler(UserAlreadyExistsException.class)
    ResponseEntity<ErrorDTO> userAlreadyExistsHandler(UserAlreadyExistsException e);

    @ExceptionHandler(UserIsAlreadyFollowingException.class)
    ResponseEntity<ErrorDTO> userIsAlreadyFollowingHandler(UserIsAlreadyFollowingException e);

    @ExceptionHandler(UserIsNotFollowingException.class)
    ResponseEntity<ErrorDTO> userIsNotFollowingHandler(UserIsNotFollowingException e);

    @ExceptionHandler(ActionNotAllowedException.class)
    ResponseEntity<ErrorDTO> actionNotAllowedHandler(ActionNotAllowedException e);

    @ExceptionHandler(UserCannotFollowThemselfException.class)
    ResponseEntity<ErrorDTO> userCannotFollowThemselfHandler(UserCannotFollowThemselfException e);
}
