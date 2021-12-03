package com.bootcamp.studentapi.exception;

import com.bootcamp.studentapi.dto.response.ErrorDTO;
import com.bootcamp.studentapi.exception.studentExceptions.StudentAlreadyExists;
import com.bootcamp.studentapi.exception.studentExceptions.StudentNotFound;
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
public class MyExceptionHandler {

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

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(StudentNotFound e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 404: Not_found_student",
                        e.getMessage() ),
                HttpStatus.resolve(404));
    }


    @ExceptionHandler(StudentAlreadyExists.class)
    public ResponseEntity<ErrorDTO> NotFoundUser(StudentAlreadyExists e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Status Code 400: Student_already_exists",
                        e.getMessage() ),
                HttpStatus.resolve(400));
    }


}
