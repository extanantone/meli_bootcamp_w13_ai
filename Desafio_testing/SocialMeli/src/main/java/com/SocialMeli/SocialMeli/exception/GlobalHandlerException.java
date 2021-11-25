package com.SocialMeli.SocialMeli.exception;

import com.SocialMeli.SocialMeli.dto.MessageDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(Exception e){
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDTOResponse);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> AlreadyExistsException(Exception e){
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDTOResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> BadRequestException(Exception e){
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDTOResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<MessageDTOResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(messageDTOResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<MessageDTOResponse> handleValidationExceptions(HttpMessageNotReadableException e) {
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(messageDTOResponse, HttpStatus.BAD_REQUEST);
    }
}
