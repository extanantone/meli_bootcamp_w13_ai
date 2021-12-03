package com.meli.probandojpa.exceptio;

import com.meli.probandojpa.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class StudentException {

    @ExceptionHandler(UserDuplicateException.class)
    public ResponseEntity<ErrorDTO> get(UserDuplicateException e) {
        return new ResponseEntity<>(
                new ErrorDTO(
                        "Duplicate_Key",
                        e.getMessage()),
                HttpStatus.CONFLICT);

    }
}
