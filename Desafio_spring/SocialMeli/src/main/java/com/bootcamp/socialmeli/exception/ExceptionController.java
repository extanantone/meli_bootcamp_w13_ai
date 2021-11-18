package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(UserIdNotFound.class)
    public ResponseEntity<MessageDTO> userIdNotFoundHandler (UserIdNotFound e) {
        return new ResponseEntity<>(new MessageDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FollowFound.class)
    public ResponseEntity<MessageDTO> followFoundHandler (FollowFound e) {
        return new ResponseEntity<>(new MessageDTO(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
