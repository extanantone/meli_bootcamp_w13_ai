package com.SocialMeli.Sprint1SocialMeli.Exception;

import com.SocialMeli.Sprint1SocialMeli.DTO.ErrorDTO;
import com.SocialMeli.Sprint1SocialMeli.DTO.ValidFieldErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionSocialMeliHandler {


    @ExceptionHandler(NotFoundUsuarioException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundUsuarioException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_usuario",
                        e.getMessage()),
                HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(NotExistOrderExeption.class)
    public ResponseEntity<ErrorDTO> get(NotExistOrderExeption e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_Order",
                        e.getMessage()),
                HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler(UserduplicateFollowExeption.class)
    public ResponseEntity<ErrorDTO> get(UserduplicateFollowExeption e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "duplicate_key",
                        e.getMessage()),
                HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(PostIdDuplicateVendedorExeption.class)
    public ResponseEntity<ErrorDTO> get(PostIdDuplicateVendedorExeption e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "duplicate_key",
                        e.getMessage()),
                HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(UserNoFollowExeption.class)
    public ResponseEntity<ErrorDTO> get(UserNoFollowExeption e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "No_preset_key",
                        e.getMessage()),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> error(
            MethodArgumentNotValidException exception) {

        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();

        List<ValidFieldErrorDTO> validList = new ArrayList<>();

        for (FieldError fe : errors) {
            ValidFieldErrorDTO valid = new ValidFieldErrorDTO( fe.getField(), fe.getDefaultMessage() );
            validList.add( valid );
        }


        return new ResponseEntity<>(
                new ErrorDTO(
                        "validation_error",
                        "Some data are invalid",
                        validList),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
