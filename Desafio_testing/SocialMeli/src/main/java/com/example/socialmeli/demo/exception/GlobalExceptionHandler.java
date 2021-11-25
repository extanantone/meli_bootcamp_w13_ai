package com.example.socialmeli.demo.exception;

import com.example.socialmeli.demo.dto.DTOError;
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
public class GlobalExceptionHandler {

    @ExceptionHandler(FollowingItselfException.class)
    public ResponseEntity<?> followingItselfException(){
        return new ResponseEntity<>("El usuario esta intentando seguirse a si mismo.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(){
        return new ResponseEntity<>("No se ha encontrado al usuario solicitado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VendorNotFoundException.class)
    public ResponseEntity<?> vendorNotFoundException(){
        return new ResponseEntity<>("No se ha encontrado al vendedor ingresado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFollowingToUserException.class)
    public ResponseEntity<?> userNotFollowingToUserRequested(){
        return new ResponseEntity<>("El usuario no se encontraba siguiendo al usuario solicitado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFollowingToUser.class)
    public ResponseEntity<?> userAleradyFollowingToUser(){
        return new ResponseEntity<>("El usuario ya se encuentra siguiendo al usuario enviado.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<DTOError> validatingDataTypes(MethodArgumentNotValidException exception){
        DTOError errorDTO = new DTOError();
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
