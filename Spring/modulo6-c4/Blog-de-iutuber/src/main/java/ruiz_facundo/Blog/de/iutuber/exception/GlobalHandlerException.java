package ruiz_facundo.Blog.de.iutuber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity duplicateHandlerException(String exMessage) {
        return new ResponseEntity<>(exMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundHandlerException(String exMessage) {
        return new ResponseEntity<>(exMessage, HttpStatus.NOT_FOUND);
    }
}
