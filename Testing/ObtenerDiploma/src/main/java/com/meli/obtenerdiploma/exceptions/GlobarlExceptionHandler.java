package com.meli.obtenerdiploma.exceptions;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice(annotations = RestController.class)
public class GlobarlExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){

        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setName("No se puede calcular el promedio del alumno.");

        errorDTO.setMessage("Alguno/s de los campos que está tratando de ingresar tienen un formato inválido");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception.getFieldErrors().forEach( e-> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            errors.compute(field,($,l) ->
                    new ArrayList<>(){
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(field + " : " + msg);
                        }
                    });
        });
        errorDTO.setErrors(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}