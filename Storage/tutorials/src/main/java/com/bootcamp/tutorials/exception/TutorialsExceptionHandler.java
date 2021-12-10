package com.bootcamp.tutorials.exception;

import com.bootcamp.tutorials.dto.response.ErrorDTO;
import com.bootcamp.tutorials.exception.tutorialException.NotFoundTutorialException;
import com.bootcamp.tutorials.exception.tutorialException.TutorialAlreadyExistsException;
import com.bootcamp.tutorials.exception.tutorialException.TutorialAlreadyPublishedException;
import com.bootcamp.tutorials.exception.tutorialException.TutorialNotPublishedException;
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
    public ResponseEntity<ErrorDTO> TutorialAlreadyExists(TutorialAlreadyExistsException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 409: Tutorial_already_exists",
                        e.getMessage() ),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundTutorialException.class)
    public ResponseEntity<ErrorDTO> NotFoundTutorial(NotFoundTutorialException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 404: Tutorial_not_found",
                        e.getMessage() ),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TutorialAlreadyPublishedException.class)
    public ResponseEntity<ErrorDTO> PublishTutorialException(TutorialAlreadyPublishedException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Tutorial_published_already",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TutorialNotPublishedException.class)
    public ResponseEntity<ErrorDTO> PublishTutorialException(TutorialNotPublishedException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Tutorial_Not_published_yet",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST);
    }

}
