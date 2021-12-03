package com.example.h2crud.excepctions;


import com.example.h2crud.dto.ErrorDto;
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
public class ExceptionHandlers {

        @ExceptionHandler(NotFoundException.class)
        public ResponseEntity<?> NotFoundException(NotFoundException e){
            ErrorDto error = new ErrorDto();
            error.setMessage(e.getMessage());
            return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    ResponseEntity<ErrorDto> validatingDataTypes(MethodArgumentNotValidException exception){
        ErrorDto errorDTO = new ErrorDto();
        errorDTO.setName("Payload's Field Not Valid Exception");
        errorDTO.setMessage("There are some fields that don't respect validations");

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
