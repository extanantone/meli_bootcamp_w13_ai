package com.socialmeli.socialmeli.exceptions.handler;

import com.socialmeli.socialmeli.controller.UserController;
import com.socialmeli.socialmeli.exceptions.postExceptions.ExistingPostException;
import com.socialmeli.socialmeli.exceptions.userExceptions.*;
import com.socialmeli.socialmeli.exceptions.errorDTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = UserController.class)
public class UserControllerHandlerException {
    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<?> NotFoundException(NotFoundUserException e){
        ErrorDTO error = new ErrorDTO("User not found","The user with id "+e.getId()+" not found");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistingRelationshipException.class)
    public ResponseEntity<?> ExistingRelationshipException(ExistingRelationshipException e){
        ErrorDTO error = new ErrorDTO("Existing relationship\n","The user with id "+e.getId()+" already follow user "+e.getId_to_follow());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowYourselfException.class)
    public ResponseEntity<?> FollowYourselfException(FollowYourselfException e){
        ErrorDTO error = new ErrorDTO("Can't follow himself","The user can't follow himself");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NegativeIdException.class)
    public ResponseEntity<?> NegativeIdException(NegativeIdException e){
        ErrorDTO error = new ErrorDTO("Id negative","the id "+e.getId()+" cannot be negative");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotExistingRelationshipException.class)
    public ResponseEntity<?> NotExistingRelationshipException(NotExistingRelationshipException e){
        ErrorDTO error = new ErrorDTO("Not existing relationship\n","The user with id "+e.getId()+" not follow user "+e.getId_to_follow());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnfollowYourselfException.class)
    public ResponseEntity<?> UnfollowYourselfException(UnfollowYourselfException e){
        ErrorDTO error = new ErrorDTO("Can't follow himself","The user can't follow himself");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
