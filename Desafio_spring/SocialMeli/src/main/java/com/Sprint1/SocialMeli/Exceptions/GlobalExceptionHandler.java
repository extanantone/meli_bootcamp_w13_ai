package com.Sprint1.SocialMeli.Exceptions;

import com.Sprint1.SocialMeli.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> UserNotFoundException (Exception e){
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestExcepcion.class)
    public ResponseEntity<ResponseDTO> BadRequestException (Exception e){
        return new ResponseEntity<ResponseDTO>(new ResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
