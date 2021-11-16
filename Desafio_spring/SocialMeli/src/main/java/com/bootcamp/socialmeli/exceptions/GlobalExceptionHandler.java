package com.bootcamp.socialmeli.exceptions;


import com.bootcamp.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> NotFoundException(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = "Not Found";
        }
        return new ResponseEntity<>(
                new ErrorDTO(404, message),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> BadRequestException(Exception e) {
        String message = e.getMessage();
        if (message == null) {
            message = "Bad Request";
        }
        return new ResponseEntity<>(
                new ErrorDTO(403, message),
                HttpStatus.BAD_REQUEST
        );
    }
}
