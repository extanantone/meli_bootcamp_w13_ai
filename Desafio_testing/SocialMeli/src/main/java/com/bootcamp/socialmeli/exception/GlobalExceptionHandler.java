package com.bootcamp.socialmeli.exception;

import com.bootcamp.socialmeli.dto.GenericExceptionDTO;
import com.bootcamp.socialmeli.dto.ValidationErrorDTO;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GenericExceptionDTO> userNotFoundExceptionHandler(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(HttpStatus.NOT_FOUND.value(),e.getMessage()));
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<GenericExceptionDTO> internalErrorExceptionHandler(InternalServerError e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericExceptionDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()));
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<GenericExceptionDTO> postNotFoundExceptionHandler(PostNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(HttpStatus.NOT_FOUND.value(),e.getMessage()));
    }

    @ExceptionHandler(MissingBodyException.class)
    public ResponseEntity<GenericExceptionDTO> missingBodyExceptionHandler(MissingBodyException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(MissingBodyAttributeException.class)
    public ResponseEntity<GenericExceptionDTO> missingBodyAttributeExceptionHandler(MissingBodyAttributeException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericExceptionDTO> badRequestExceptionHandler(BadRequestException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(IllegalRequestParamException.class)
    public ResponseEntity<GenericExceptionDTO> badRequestExceptionHandler(IllegalRequestParamException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericExceptionDTO(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorDTO methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ValidationErrorDTO constraintViolationExceptionHandler(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> result = ex.getConstraintViolations();
        return processFieldErrors(result);
    }

    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
        ValidationErrorDTO error = new ValidationErrorDTO(HttpStatus.BAD_REQUEST.value(), "validation error");
        for (FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }

    private ValidationErrorDTO processFieldErrors(Set<ConstraintViolation<?>> constraintViolations) {
        ValidationErrorDTO error = new ValidationErrorDTO(HttpStatus.BAD_REQUEST.value(), "validation error");
        for (ConstraintViolation<?> violation : constraintViolations) {
            error.addFieldError(((PathImpl) violation.getPropertyPath()).getLeafNode().getName(), violation.getMessage());
        }
        return error;
    }
}
