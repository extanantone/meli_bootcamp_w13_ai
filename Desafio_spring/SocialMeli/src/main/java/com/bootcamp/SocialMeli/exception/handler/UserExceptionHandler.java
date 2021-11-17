package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import com.bootcamp.SocialMeli.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundHandler(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "user_not_found",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND );

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> userAlreadyExistsHandler(UserAlreadyExistsException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "user_already_exists",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(UserIsAlreadyFollowingException.class)
    public ResponseEntity<ErrorDTO> userIsAlreadyFollowingHandler(UserIsAlreadyFollowingException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "user_is_already_following",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(UserIsNotFollowingException.class)
    public ResponseEntity<ErrorDTO> userIsNotFollowingHandler(UserIsNotFollowingException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "user_is_not_following",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(ActionNotAllowedException.class)
    public ResponseEntity<ErrorDTO> actionNotAllowedHandler(ActionNotAllowedException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "action_not_allowed",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(UserCannotFollowThemselfException.class)
    public ResponseEntity<ErrorDTO> userCannotFollowThemselfHandler(UserCannotFollowThemselfException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "user_cannot_follow_themselves",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );
    }
}

