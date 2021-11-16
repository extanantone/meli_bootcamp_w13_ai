package meli.bootcamp.socialmeli.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {

    //Consultar si esto se puede manejar como una excepcion.
    @ExceptionHandler(value= {UserAlreadyFollowsException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario ya sigue a esta cuenta.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    //Consultar si esto se puede manejar como una excepcion.
    @ExceptionHandler(value= {UserNotFollowsException.class})
    protected ResponseEntity<Object> handleUSerNotFollows(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario no sigue a esta cuenta.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value= {UserNotExistException.class})
    protected ResponseEntity<Object> handleUserNotExist(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario no existe dentro del sistema.");
        bodyOfResponse.put("response_code", "404");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value= {PostAlreadyExistException.class})
    protected ResponseEntity<Object> handlePostAlreadyExist(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El post con dicho ID ya existe dentro del sistema. Cree uno nuevo con diferente ID.");
        bodyOfResponse.put("response_code", "404");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
