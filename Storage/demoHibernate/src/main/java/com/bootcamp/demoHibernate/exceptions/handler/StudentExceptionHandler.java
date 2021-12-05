package com.bootcamp.demoHibernate.exceptions.handler;

import com.bootcamp.demoHibernate.dto.ErrorDTO;
import com.bootcamp.demoHibernate.exceptions.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(StudentException.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(StudentException exception){
        exception.printStackTrace();
        return new ResponseEntity<>(exception.getError(), exception.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDTO> hadleGlobalException(Exception ex){
        ex.printStackTrace();
        return new ResponseEntity<>(
                new ErrorDTO("GeneralError", "Problema interno"),
                HttpStatus.INTERNAL_SERVER_ERROR );
    }

}
