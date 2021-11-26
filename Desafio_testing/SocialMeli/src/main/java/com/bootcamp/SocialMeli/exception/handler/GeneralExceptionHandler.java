package com.bootcamp.SocialMeli.exception.handler;

import com.bootcamp.SocialMeli.dto.response.ErrorDTO;
import com.bootcamp.SocialMeli.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class GeneralExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowException.class)
    public ResponseEntity<?> alreadyFollowException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EqualsUserSellerException.class)
    public ResponseEntity<?> equalsUserSellerException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<?> notFollowException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<?> userNotSellerException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateIDException.class)
    public ResponseEntity<?> duplicateIDException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FutureDateException.class)
    public ResponseEntity<?> futureDateException(Exception e){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(e.getClass().getSimpleName());
        error.setMensaje(e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDiscountException.class)
    public ResponseEntity<?> invalidDiscountException(){
        ErrorDTO error = new ErrorDTO();
        error.setTipo("InvalidDiscountException");
        error.setMensaje("El descuento a aplicar debe estar comprendido entre 0% y 100%");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<?> invalidPriceException(){
        ErrorDTO error = new ErrorDTO();
        error.setTipo("InvalidPriceException");
        error.setMensaje("El precio del producto no puede ser negativo");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> nullPointerException(){
        ErrorDTO error = new ErrorDTO();
        error.setTipo("NullPointerException");
        error.setMensaje("Error en la request");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //@ExceptionHandler(MethodArgumentNotValidException.class)
    //@ExceptionHandler(HttpMessageNotReadableException.class)

   /* @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(){
        return new ResponseEntity<>(new ErrorDTO("Error en la request"), HttpStatus.BAD_REQUEST);
    }*/

    //TODO usar metodo
    private ResponseEntity<?> getErrorResponseEntity(String tipo, String msj, HttpStatus status){
        ErrorDTO error = new ErrorDTO();
        error.setTipo(tipo);
        error.setMensaje(msj);
        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validarArgumentosDeEntrada(MethodArgumentNotValidException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTipo(ex.getClass().getSimpleName());
        errorDTO.setMensaje("Hay algunos campos que no respetan las validaciones.");
        Map<String, List<String>> errors = new HashMap<>();

        ex.getFieldErrors().forEach(
                e -> {
                    String field = e.getField();
                    String msj = e.getDefaultMessage();

                    errors.computeIfPresent(field, (k,v) -> new ArrayList<>(){{addAll(v); add(msj);}});
                    errors.computeIfAbsent(field, f -> new ArrayList<>(){{add(msj);}});
                }
        );
        errorDTO.setErrorFields(errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> mensajeHttpNoLegible(HttpMessageNotReadableException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setTipo(ex.getClass().getSimpleName());
        errorDTO.setMensaje("El JSON de la request tiene un formato invalido");
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
