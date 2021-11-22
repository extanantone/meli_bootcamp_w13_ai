

package com.example.socialMeli.exceptions;

import com.example.socialMeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontradoError.class)
    public ResponseEntity<ErrorDTO> get(UsuarioNoEncontradoError e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> errorDto(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> errorDto2(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }
}