package com.example.socialmeli.exception.handler;

import com.example.socialmeli.dto.exception.ErrorDTO;
import com.example.socialmeli.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class FollowControllerHandlerException
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex)
    {//ex.getFieldError().getField() + " : " +ex.getFieldError().getDefaultMessage());
        ErrorDTO errorDTO = new ErrorDTO(
                "MethodArgumentNotValidException",
                "Not Valid"
                , ex.getFieldErrors().stream().map(
                        error -> (error.getField() + " : " + error.getDefaultMessage()
                        )).collect(Collectors.toList()));
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException ex)
    {
        ErrorDTO errorDTO = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e)
    {
        ErrorDTO error = new ErrorDTO("Acción no valida", "Error: " + e.getMsg());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
