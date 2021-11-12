package com.bootcamp.SocialMeli.Exception.Handler;

import com.bootcamp.SocialMeli.DTO.Errores.ErrorDTO;
import com.bootcamp.SocialMeli.Exception.InvalidFollowExceptionUser;
import com.bootcamp.SocialMeli.Exception.NotFoundExceptionUsers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerUsers {

    @ExceptionHandler(NotFoundExceptionUsers.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundExceptionUsers e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidFollowExceptionUser.class)
    public ResponseEntity<?> handleInvalidPost(InvalidFollowExceptionUser e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage()));
    }
}
