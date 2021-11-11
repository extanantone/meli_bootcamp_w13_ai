package com.bootcamp.apimessengers.exception;

import com.bootcamp.apimessengers.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundMessengerException.class)
    public ResponseEntity<?> NotFoundLinkException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO("Not_Found_Messenger",e.getMessage()));
    }

}





