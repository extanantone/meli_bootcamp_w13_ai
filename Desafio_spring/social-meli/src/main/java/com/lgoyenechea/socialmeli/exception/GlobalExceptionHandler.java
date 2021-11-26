package com.lgoyenechea.socialmeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserDoesNotFollowException.class)
    public ResponseEntity<Object> userDoesNotFollowException(UserDoesNotFollowException userDoesNotFollowException) {
        Error error = new Error();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setMessage(userDoesNotFollowException.getMessage());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(value = UserDoesNotExistsException.class)
    public ResponseEntity<Object> userDoesNotExistsException(UserDoesNotExistsException userDoesNotExistsException) {
        Error error = new Error();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(userDoesNotExistsException.getMessage());
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
