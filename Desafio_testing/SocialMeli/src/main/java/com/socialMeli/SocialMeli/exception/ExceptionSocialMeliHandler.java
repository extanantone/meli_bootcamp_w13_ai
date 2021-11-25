package com.socialMeli.SocialMeli.exception;

import com.socialMeli.SocialMeli.exception.postExceptions.ExistingPostException;
import com.socialMeli.SocialMeli.exception.postExceptions.NotFoundIdPostException;
import com.socialMeli.SocialMeli.exception.userExceptions.AlreadyFollowedUserException;
import com.socialMeli.SocialMeli.exception.userExceptions.FollowItselfException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFollowingUserException;
import com.socialMeli.SocialMeli.exception.userExceptions.NotFoundUserException;
import com.socialMeli.SocialMeli.userDto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionSocialMeliHandler {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(NotFoundUserException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowedUserException.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(AlreadyFollowedUserException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowingUserException.class)
    public ResponseEntity<ErrorDTO> NotFollowingUser(NotFollowingUserException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingPostException.class)
    public ResponseEntity<ErrorDTO> ExistingPostException(ExistingPostException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowItselfException.class)
    public ResponseEntity<ErrorDTO> FollowItselfException(FollowItselfException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundIdPostException.class)
    public ResponseEntity<ErrorDTO> NotFoundIdPostException(NotFoundIdPostException e){
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResponseEntity<>(new ErrorDTO("Parametros incorrectos"), HttpStatus.BAD_REQUEST);
    }
}
