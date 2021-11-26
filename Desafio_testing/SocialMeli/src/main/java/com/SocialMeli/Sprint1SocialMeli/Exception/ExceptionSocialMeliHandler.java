package com.SocialMeli.Sprint1SocialMeli.Exception;

import com.SocialMeli.Sprint1SocialMeli.DTO.MensajeExcepcionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice (annotations = RestController.class)

public class ExceptionSocialMeliHandler {


    @ExceptionHandler(NotFoundVendedorException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(NotFoundVendedorException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! not_found_vendedor ",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(NotFoundCompradorException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(NotFoundCompradorException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! not_found_comprador ",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(DuplicateFollowedException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(DuplicateFollowedException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! usuario_ya_sigue_vendedor",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    @ExceptionHandler(DuplicatePostException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(DuplicatePostException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! publicacion_ya_existente",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(NotFollowException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! no_sigue_comprador",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(NotValidParamException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(NotValidParamException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! parametro_no_valido",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }
    @ExceptionHandler(NotFollowedException.class)
    public ResponseEntity<MensajeExcepcionDTO> get(NotFollowedException e) {
        return new ResponseEntity<>(
                new MensajeExcepcionDTO(
                        "ERROR! no_sigue_vendedores",
                        e.getMessage() ),
                HttpStatus.BAD_REQUEST );

    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeExcepcionDTO> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(new MensajeExcepcionDTO(e.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }*/

}
