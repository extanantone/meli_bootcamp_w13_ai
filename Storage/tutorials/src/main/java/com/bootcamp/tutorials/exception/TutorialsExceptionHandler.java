package com.bootcamp.tutorials.exception;

import com.bootcamp.tutorials.dto.response.ErrorDTO;
import com.bootcamp.tutorials.exception.tutorialException.TutorialAlreadyExistsException;
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
public class TutorialsExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){

        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setCode("Payload's field Not Valid Exception");

        errorDTO.setMessage("There are some fields that don't respect validations.");

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

    @ExceptionHandler(TutorialAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> PostAlreadyExists(TutorialAlreadyExistsException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 409: Tutorial_already_exists",
                        e.getMessage() ),
                HttpStatus.CONFLICT);
    }

}
