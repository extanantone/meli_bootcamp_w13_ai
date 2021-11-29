package com.example.socialmeli.exceptions;

import com.example.socialmeli.dto.DTOError.ErrorDTO;
import com.example.socialmeli.dto.DTOResponses.DTOEmptyJsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNoFound.class)
    public ResponseEntity<?> UserNoFound(UserNoFound e){
        ErrorDTO error = new ErrorDTO("El usuario " + e.getI()+"  no fue encontrado", 400);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ErrorInOperation.class)
    public ResponseEntity<?> ErrorInOperation(Exception e){
        ErrorDTO error = new ErrorDTO("Verifica que todos los campos necesarios esten completos", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler(PostAlreadyCreated.class)
    public ResponseEntity<?> PostAlreadyCreated(Exception e){
        ErrorDTO error = new ErrorDTO("El numero de id_post ya existe en el sistema, ingresa otro distinto", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ActionPrevioslyComplete.class)
    public ResponseEntity<?> ActionPrevioslyComplete(Exception e){
        DTOEmptyJsonResponse empty = new DTOEmptyJsonResponse();
        ErrorDTO error = new ErrorDTO("Acción ya realizada", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ActionRedundant.class)
    public ResponseEntity<?> ActionRedundant(Exception e){
        DTOEmptyJsonResponse empty = new DTOEmptyJsonResponse();
        ErrorDTO error = new ErrorDTO("Acción redundante", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(OrderNoFound.class)
    public ResponseEntity<?> OrderNoFound(Exception e){
        DTOEmptyJsonResponse empty = new DTOEmptyJsonResponse();
        ErrorDTO error = new ErrorDTO("el parametro para el ordernamiento no existe", 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
