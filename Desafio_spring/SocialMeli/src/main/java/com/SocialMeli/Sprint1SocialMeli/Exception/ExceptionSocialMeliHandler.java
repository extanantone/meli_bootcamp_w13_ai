package com.SocialMeli.Sprint1SocialMeli.Exception;

import com.SocialMeli.Sprint1SocialMeli.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)

public class ExceptionSocialMeliHandler {


    @ExceptionHandler(NotFoundVendedorException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundVendedorException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_vendedor ",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(NotFoundCompradorException.class)
    public ResponseEntity<ErrorDTO> get(NotFoundCompradorException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "not_found_comprador ",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(DuplicateFollowedException.class)
    public ResponseEntity<ErrorDTO> get(DuplicateFollowedException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "usuario_ya_sigue_vendedor",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(DuplicatePostException.class)
    public ResponseEntity<ErrorDTO> get(DuplicatePostException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "publicacion_ya_existente",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<ErrorDTO> get(NotFollowException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "no_sigue_comprador",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(NotValidParamException.class)
    public ResponseEntity<ErrorDTO> get(NotValidParamException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "parametro_no_valido",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

}
