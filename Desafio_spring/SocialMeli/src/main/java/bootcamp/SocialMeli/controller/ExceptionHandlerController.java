package bootcamp.SocialMeli.controller;

import bootcamp.SocialMeli.dto.ExceptionDto;
import bootcamp.SocialMeli.exception.InvalidPostException;
import bootcamp.SocialMeli.exception.InvalidUserException;
import bootcamp.SocialMeli.exception.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<?> handlerInvalidUser(InvalidUserException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundUserException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDto(e.getMessage()));
    }

    @ExceptionHandler(InvalidPostException.class)
    public ResponseEntity<?> handlerInvalidPost(InvalidPostException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDto(e.getMessage()));
    }
}
