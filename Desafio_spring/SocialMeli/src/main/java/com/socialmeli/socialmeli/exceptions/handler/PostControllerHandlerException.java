package com.socialmeli.socialmeli.exceptions.handler;

import com.socialmeli.socialmeli.controller.PostController;
import com.socialmeli.socialmeli.exceptions.errorDTO.ErrorDTO;
import com.socialmeli.socialmeli.exceptions.postExceptions.ExistingPostException;
import com.socialmeli.socialmeli.exceptions.userExceptions.ExistingRelationshipException;
import com.socialmeli.socialmeli.exceptions.userExceptions.NotExistingRelationshipException;
import com.socialmeli.socialmeli.exceptions.userExceptions.NotFoundUserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = PostController.class)
public class PostControllerHandlerException {

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> NotFoundException(NotFoundUserException e){
        ErrorDTO error = new ErrorDTO("User not found","The user with id "+e.getId()+" not found");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingPostException.class)
    public ResponseEntity<?> ExistingPostException(ExistingPostException e){
        ErrorDTO error = new ErrorDTO("Existing post","the id "+e.getId()+" allready create");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }


}
