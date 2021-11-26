package com.lgoyenechea.socialmeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotFollowException.class)
    public ResponseEntity<Object> userDoesNotFollowException(UserNotFollowException userDoesNotFollowException) {
        Error error = new Error();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage(userDoesNotFollowException.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userDoesNotExistsException(UserNotFoundException userNotFoundException) {
        Error error = new Error();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(userNotFoundException.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationErrors errors = new ValidationErrors();

        methodArgumentNotValidException.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    ValidationError validationError = new ValidationError(fieldName, errorMessage);
                    errors.getDetails().add(validationError);
                });
        errors.setStatus(HttpStatus.BAD_REQUEST);
        return buildResponseEntity(errors);
    }

    private ResponseEntity<Object> buildResponseEntity(Error error) {
        return new ResponseEntity<>(error, error.getStatus());
    }

    private ResponseEntity<Object> buildResponseEntity(ValidationErrors errors) {
        return new ResponseEntity<>(errors, errors.getStatus());
    }
}
