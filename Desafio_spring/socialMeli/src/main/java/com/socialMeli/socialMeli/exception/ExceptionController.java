package com.socialMeli.socialMeli.exception;
import com.socialMeli.socialMeli.dto.MensajeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?>userNotFoundHandler(UserNotFoundException e){
        return new ResponseEntity<>(new MensajeDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserFollowingHimselfException.class)
    public ResponseEntity<?>usetFollowingHimselfHandler(UserFollowingHimselfException e){
        return new ResponseEntity<>(new MensajeDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserFollowingAnotherUserTwice.class)
    public ResponseEntity<?>userFollowingAnotherUserTwiceHandler(UserFollowingAnotherUserTwice e){
        return new ResponseEntity<>(new MensajeDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RepeatedPostException.class)
    public ResponseEntity<?>repeatedPostHandler(RepeatedPostException e){
        return new ResponseEntity<>(new MensajeDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
