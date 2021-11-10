package com.bootcamp.messengers.exceptions;

import com.bootcamp.messengers.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GeneralHandlerException {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> missingServletRequestParameterException(){
        ErrorDTO error = new ErrorDTO();
        error.setType("Bad Request - Request param empty");
        error.setMessage("Debe especificar el mensaje");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setType("Not Found - ID");
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecursosInsuficientesException.class)
    public ResponseEntity<ErrorDTO> recursosInsuficientesException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setType("Mensaje NO enviado");
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ErrorDTO> classCastException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setType("Mensajero incorrecto - ID");
        error.setMessage("El ID no corresponde al tipo del mensajero");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> illegalArgumentException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setType("Argumento invalido");
        error.setMessage("Ha ingresado un argumento invalido.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
