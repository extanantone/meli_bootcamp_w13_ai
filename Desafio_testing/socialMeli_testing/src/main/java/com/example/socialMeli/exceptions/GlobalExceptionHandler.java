

package com.example.socialMeli.exceptions;

import com.example.socialMeli.dto.ErrorDTO;
import com.example.socialMeli.dto.ErrorValidacionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontradoError.class)
    public ResponseEntity<ErrorDTO> get(UsuarioNoEncontradoError e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),400);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorValidacionDTO> validatingDataTypes(MethodArgumentNotValidException exception){
        ErrorValidacionDTO errorDTO = new ErrorValidacionDTO("Algunos campos ingresados no respetan la validación:.",400);
        HashMap<String, List<String>> errors = new HashMap<>();
        exception.getFieldErrors().forEach( e-> {
            String field = e.getField();
            String msg = e.getDefaultMessage();
            errors.compute(field,($,l) ->
               new ArrayList<>(){                {
                    addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                    add(field + " : " + msg);
               }});
        });
        errorDTO.setErrors(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(), 404);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
