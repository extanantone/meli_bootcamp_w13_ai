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

import javax.validation.ConstraintViolationException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class GeneralExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArgumentException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowException.class)
    public ResponseEntity<?> alreadyFollowException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EqualsUserSellerException.class)
    public ResponseEntity<?> equalsUserSellerException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowException.class)
    public ResponseEntity<?> notFollowException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotSellerException.class)
    public ResponseEntity<?> userNotSellerException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateIDException.class)
    public ResponseEntity<?> duplicateIDException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FutureDateException.class)
    public ResponseEntity<?> futureDateException(Exception e){
        return getErrorResponseEntity(e.getClass().getSimpleName(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDiscountException.class)
    public ResponseEntity<?> invalidDiscountException(){
        return getErrorResponseEntity("InvalidDiscountException", "El descuento a aplicar debe estar comprendido entre 0% y 100%", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPriceException.class)
    public ResponseEntity<?> invalidPriceException(){
        return getErrorResponseEntity("InvalidPriceException", "El precio del producto no puede ser negativo", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> nullPointerException(){
        return getErrorResponseEntity("NullPointerException", "Error en la request", HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorDTO> getErrorResponseEntity(String tipo, String msj, HttpStatus status){
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
        //errorDTO.setMensaje(ex.getMessage());

        if(ex.getMostSpecificCause().getClass() == DateTimeParseException.class){
            errorDTO.setMensaje("Fecha de publicación con formato inválido. El formato permitido es 'dd-MM-yyyy'.");
        }

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    //Excepcion que se genera cuando el RequestParam 'order' no es correcto
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validarPathVariables(ConstraintViolationException ex){
        return getErrorResponseEntity(ex.getClass().getSimpleName(), ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
