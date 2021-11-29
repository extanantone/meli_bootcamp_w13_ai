package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.*;
import com.bootcamp.SocialMeli.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class SocialMeliHandlerException {
    @ExceptionHandler(DeniedActionException.class)
    public ResponseEntity<ResponseDTO> getException(DeniedActionException e) {
        return new ResponseEntity<>(
                new ResponseDTO("denied_action", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateIDPostException.class)
    public ResponseEntity<ResponseDTO> getException(DuplicateIDPostException e) {
        return new ResponseEntity<>(
                new ResponseDTO("duplicate_id", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<ResponseDTO> getException(InvalidOrderException e) {
        return new ResponseEntity<>(
                new ResponseDTO("invalid_order", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO> getException(UserNotFoundException e) {
        return new ResponseEntity<>(
                new ResponseDTO("user_not_found", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> getValidationException(MethodArgumentNotValidException e) {
        List<ResponseDetailDTO> details = new ArrayList<>();

        e.getFieldErrors().forEach(x -> details.add(
                new ResponseDetailDTO(camelCaseToUnderscore(x.getField()), x.getDefaultMessage())));

        ResponseDTO responseDTO = new ResponseDTO(
                "validation_error",
                "Se han producido los siguientes errores al validar los datos ingresados:",
                details);

        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    private String camelCaseToUnderscore(String camelCase) {
        String underscore = String.valueOf(Character.toLowerCase(camelCase.charAt(0)));

        for (int i = 1; i < camelCase.length(); i++) {
            underscore += Character.isLowerCase(camelCase.charAt(i)) ? String.valueOf(camelCase.charAt(i))
                    : "_" + Character.toLowerCase(camelCase.charAt(i));
        }

        if (underscore.contains("detail")) {
            underscore = underscore.replaceFirst("_", "");
        }

        return underscore;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> getValidationException(HttpMessageNotReadableException e) {
        ResponseDTO responseDTO = new ResponseDTO("validation_error", e.getMessage());

        if (e.getMessage().contains("DateTimeParseException")) {
            responseDTO.setMessage("El formato de fecha ingresado es inválido. Debe respetarse dd-MM-yyyy.");
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}