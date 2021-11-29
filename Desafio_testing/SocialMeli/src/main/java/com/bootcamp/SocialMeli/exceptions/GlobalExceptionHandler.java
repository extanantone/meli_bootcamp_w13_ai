package com.bootcamp.SocialMeli.exceptions;

import com.bootcamp.SocialMeli.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> UserNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(SameUserException.class)
    public ResponseEntity<?> SameUserException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(IdAlreadyCreatedException.class)
    public ResponseEntity<?> IdAlreadyCreated(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ErrorDTO("Parámetros incorrectos"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoValidOrderException.class)
    public ResponseEntity<?> NoValidOrderException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    ResponseEntity<ErrorDTO> validatingDataTypes(MethodArgumentNotValidException exception){
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setName("Payload's Field Not Valid Exception");
//        errorDTO.setMessage("There are some fields that don't respect validations");
//
//        HashMap<String, List<String>> errors = new HashMap<>();
//
//        exception.getFieldErrors().forEach( e -> {
//            String field = e.getField();
//            String msg = e.getDefaultMessage();
//
//            // Example 1
//
///*            List<String> errorFields = new ArrayList<>();
//            if (errors.containsKey(e.getField())){
//                errorFields = errors.get(field);
//            }
//            errorFields.add(msg);
//            errors.put(field, errorFields);*/
//
//            //example 2
//
///*            errors.computeIfAbsent(field,f -> new ArrayList<>(){ { add(msg); } });
//            errors.computeIfPresent(field, (f, l) -> new ArrayList<>(){ { addAll(l); add(msg); } });*/
//
//            // Example 3
//
//            errors.compute(field, ($, l) ->
//                    new ArrayList<>(){
//                        {
//                            addAll(!Objects.isNull(l) ? l : new ArrayList<>());
//                            add(msg);
//                        }
//                    }
//            );
//        });
//        errorDTO.setErrorFields(errors);
//        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
//    }

}
