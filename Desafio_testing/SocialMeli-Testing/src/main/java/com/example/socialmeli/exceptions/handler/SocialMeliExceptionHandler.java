package com.example.socialmeli.exceptions.handler;

import com.example.socialmeli.exceptions.SocialMeliException;
import com.example.socialmeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(SocialMeliException.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(SocialMeliException ex){
        ex.printStackTrace();
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO("GeneralError", "Problema interno"),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Payload's Field Not Valid Exception");
        errorDTO.setDescription("There are some fields that don't respect validations");

        HashMap<String, List<String>> errors = new HashMap<>();

        exception.getFieldErrors().forEach( e -> {
            String field = e.getField();
            String msg = e.getDefaultMessage();

            // Example 1

/*            List<String> errorFields = new ArrayList<>();
            if (errors.containsKey(e.getField())){
                errorFields = errors.get(field);
            }
            errorFields.add(msg);
            errors.put(field, errorFields);*/

            //example 2

/*            errors.computeIfAbsent(field,f -> new ArrayList<>(){ { add(msg); } });
            errors.computeIfPresent(field, (f, l) -> new ArrayList<>(){ { addAll(l); add(msg); } });*/

            // Example 3

            errors.compute(field, ($, l) ->
                    new ArrayList<>(){
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

}
