package com.meli.obtenerdiploma.exception;

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
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validarArgumentos(MethodArgumentNotValidException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTipo(ex.getClass().getSimpleName());
        errorDTO.setMessage("Hay algunos campos que no respetan las validaciones.");
        Map<String, List<String>> errors = new HashMap<>();

        ex.getFieldErrors().forEach(
                e -> {
                    String field = e.getField();
                    String msj = e.getDefaultMessage();

                    errors.computeIfPresent(field, (k,v) -> new ArrayList<>(){{addAll(v); add(msj);}});
                    errors.computeIfAbsent(field, f -> new ArrayList<>(){{add(msj);}});
                }
        );
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> mensajeHttpNoLegible(HttpMessageNotReadableException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTipo(ex.getClass().getSimpleName());
        errorDTO.setMessage("El JSON de la request tiene un formato invalido");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
