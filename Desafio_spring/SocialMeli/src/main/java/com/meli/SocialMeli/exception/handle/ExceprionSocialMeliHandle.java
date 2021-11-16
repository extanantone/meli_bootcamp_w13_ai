package com.meli.SocialMeli.exception.handle;

import com.meli.SocialMeli.dto.ErrorDTO;
import com.meli.SocialMeli.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceprionSocialMeliHandle {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException e) {
        ErrorDTO error = new ErrorDTO("invalid_parameter", "Error: " + e.getMensaje());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
