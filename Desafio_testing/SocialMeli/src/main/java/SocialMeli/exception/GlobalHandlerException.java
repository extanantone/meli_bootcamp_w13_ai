package SocialMeli.exception;

import SocialMeli.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(AlredyFollowedException.class)
    public ResponseEntity<ExceptionDTO> alreadyFollowedException() {
        return new ResponseEntity<>(new ExceptionDTO("Seller had already been followed by customer"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongIdException.class)
    public ResponseEntity<ExceptionDTO> wrongIdException(WrongIdException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMsg() + " does not exist"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RepeatedIdException.class)
    public ResponseEntity<ExceptionDTO> repeatIdException() {
        return new ResponseEntity<>(new ExceptionDTO("Id has already been taken"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFollowedException.class)
    public ResponseEntity<ExceptionDTO> notFollowedException() {
        return new ResponseEntity<>(new ExceptionDTO("Customer was not following the selected seller"), HttpStatus.BAD_REQUEST);
    }

    // Validaciones
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleValidationExceptions(MethodArgumentNotValidException e) {

        String msg = e.getFieldErrors().stream()
                .reduce("Validation error",
                        (acc, cv) -> acc + ", " + cv.getField() + " = " + cv.getDefaultMessage(), String::concat);

        return new ResponseEntity<>(new ExceptionDTO(msg), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrderMethodInexistentException.class)
    public ResponseEntity<ExceptionDTO> OrderMethodException() {
        return new ResponseEntity<>(new ExceptionDTO("Selected order method inexistent"), HttpStatus.BAD_REQUEST);
    }

}
