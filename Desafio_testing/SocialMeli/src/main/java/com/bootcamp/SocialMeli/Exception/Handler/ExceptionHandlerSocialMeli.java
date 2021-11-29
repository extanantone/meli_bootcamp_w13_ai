package com.bootcamp.SocialMeli.Exception.Handler;

import com.bootcamp.SocialMeli.DTO.Errores.ErrorDTO;
import com.bootcamp.SocialMeli.DTO.Errores.ErrorValidDTO;
import com.bootcamp.SocialMeli.Exception.InvalidSocialException;
import com.bootcamp.SocialMeli.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlerSocialMeli {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundUser(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO("NotFoundException",e.getMessage()));
    }

    @ExceptionHandler(InvalidSocialException.class)
    public ResponseEntity<?> handleInvalidPost(InvalidSocialException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("InvalidSocialException",e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorValidDTO> validatingDataTypes(MethodArgumentNotValidException e){
        ErrorValidDTO errorValidDTO = new ErrorValidDTO();
        errorValidDTO.setDesc("MethodArgumentNotValidException");
        errorValidDTO.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());

        HashMap<String, List<String>> errors = new HashMap<>();

        e.getFieldErrors().forEach( ex -> {
            String field = ex.getField();
            String msg = ex.getDefaultMessage();


            errors.compute(field, ($, l) ->
                    new ArrayList<>(){
                        {
                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
                            add(msg);
                        }
                    }
            );
        });
        errorValidDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorValidDTO, HttpStatus.BAD_REQUEST);
    }
}
