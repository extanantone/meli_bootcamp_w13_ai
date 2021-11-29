package com.SocialMeli.exceptions;

import com.SocialMeli.dto.ErrorDTO;
import com.SocialMeli.dto.ExceptionDTO;
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

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {

        return new ResponseEntity(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e) {

        return new ResponseEntity(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Payload's Field Not Valid Exception");

        HashMap<String, List<String>> errors = new HashMap<>();

        e.getFieldErrors().forEach(exception -> {
            String field = exception.getField();
            String msg = exception.getDefaultMessage();

            errors.compute(field, ($, l) ->
                    new ArrayList<>() {
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(msg);
                        }
                    }
            );
        });
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ExceptionDTO> getValidationException(HttpMessageNotReadableException e) {
//        ExceptionDTO responseDTO = new ExceptionDTO(e.getMessage());
//
//        if (e.getMessage().contains("DateTimeParseException")) {
//            responseDTO.setMessage("El formato de fecha ingresado es inválido. Debe respetarse dd-MM-yyyy.");
//        }
//
//        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
//    }
}
