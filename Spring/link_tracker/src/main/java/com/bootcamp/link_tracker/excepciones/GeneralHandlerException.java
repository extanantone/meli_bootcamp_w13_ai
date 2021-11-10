package com.bootcamp.link_tracker.excepciones;

import com.bootcamp.link_tracker.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GeneralHandlerException {

    @ExceptionHandler(LinkInexistenteException.class)
    public ResponseEntity<?> linkInexistenteException(Exception e){
        ExceptionDTO excepcion = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkInvalidoException.class)
    public ResponseEntity<?> linkInvalidoException(Exception e){
        ExceptionDTO excepcion = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<?> passwordIncorrectException(Exception e){
        ExceptionDTO excepcion = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(excepcion, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> missingServletRequestParameterException(Exception e){
        ExceptionDTO excepcion = new ExceptionDTO("Debe especificar la password");
        return new ResponseEntity<>(excepcion, HttpStatus.BAD_REQUEST);
    }

}
