package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.response.error.ErrorDTO;
import com.bootcamp.socialmeli.exception.UserException.NotFoundFollower;
import com.bootcamp.socialmeli.exception.UserException.NotFoundUsuarioException;
import com.bootcamp.socialmeli.exception.postException.PostIdAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionSocialMeliHandler {

    @ExceptionHandler(NotFoundUsuarioException.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(NotFoundUsuarioException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: not_found_user",
                        e.getMessage() ),
                HttpStatus.resolve(400));

    }

    @ExceptionHandler(PostIdAlreadyExists.class)
    public ResponseEntity<ErrorDTO> PostAlreadyExists(PostIdAlreadyExists e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: post_already_exists",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(NotFoundFollower.class)
    public ResponseEntity<ErrorDTO> NotFoundFollower(NotFoundFollower e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 404: Follower_No_exists",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND);

    }


}
