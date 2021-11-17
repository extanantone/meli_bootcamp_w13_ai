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

/**
 * @author andrmorales 
 *              Clase para listar las excepciones controladas en el sistema.
 * */
@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {

    /**
     * @return handleExceptionInternal
     *              Método que informa al usuario sobre la existencia del vinculo de seguidor.
     * */
    @ExceptionHandler(value= {UserAlreadyFollowsException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario ya sigue a esta cuenta.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
    /**
     * @return handleExceptionInternal
     *              Método que informa al usuario que no se puede seguir a el mismo.
     * */
    @ExceptionHandler(value= {UserFollowHimselfException.class})
    protected ResponseEntity<Object> handleHimselfConflict(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario no se puede seguir a si mismo.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * @return handleExceptionInternal
     *              Método que informa al usuario sobre la inexistencia del vinculo de seguidor.
     * */
    @ExceptionHandler(value= {UserNotFollowsException.class})
    protected ResponseEntity<Object> handleUSerNotFollows(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario no sigue a esta cuenta.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * @return handleExceptionInternal
     *              Método que informa al cliente sobre la inexistencia del usuario en el sistema.
     * */
    @ExceptionHandler(value= {UserNotExistException.class})
    protected ResponseEntity<Object> handleUserNotExist(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El usuario no existe dentro del sistema.");
        bodyOfResponse.put("response_code", "404");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * @return handleExceptionInternal
     *              Método que informa al cliente sobre la existencia del post en el sistema.
     * */
    @ExceptionHandler(value= {PostAlreadyExistException.class})
    protected ResponseEntity<Object> handlePostAlreadyExist(
            RuntimeException ex, WebRequest request) {
        Map<String, String> bodyOfResponse = new HashMap<>();
        bodyOfResponse.put("message", "El post con dicho ID ya existe dentro del sistema. Cree uno nuevo con diferente ID.");
        bodyOfResponse.put("response_code", "400");
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
