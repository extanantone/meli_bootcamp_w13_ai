package com.SocialMeli.SocialMeli.exception;

import com.SocialMeli.SocialMeli.dto.MessageDTOResponse;
import com.SocialMeli.SocialMeli.dto.ValidationErrorDTOResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    protected ResponseEntity<ValidationErrorDTOResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<String> details = new ArrayList<>();
        for(ObjectError error : e.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        ValidationErrorDTOResponse error = new ValidationErrorDTOResponse("Validation Failed", details);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<MessageDTOResponse> handleValidationExceptions(HttpMessageNotReadableException e) {
        MessageDTOResponse messageDTOResponse = new MessageDTOResponse();
        messageDTOResponse.setMessage(e.getMessage());
        return new ResponseEntity<>(messageDTOResponse, HttpStatus.BAD_REQUEST);
    }
}
