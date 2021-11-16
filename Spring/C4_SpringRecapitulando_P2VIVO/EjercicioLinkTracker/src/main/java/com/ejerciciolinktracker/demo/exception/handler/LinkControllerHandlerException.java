package com.ejerciciolinktracker.demo.exception.handler;

import com.ejerciciolinktracker.demo.controller.LinkController;
import com.ejerciciolinktracker.demo.dto.ErrorDTO;
import com.ejerciciolinktracker.demo.exception.LinkInvalidatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(assignableTypes = LinkController.class)
public class LinkControllerHandlerException {
    @ExceptionHandler(LinkInvalidatedException.class)
    public ResponseEntity<?> LinkInvalidatedException(LinkInvalidatedException e){
        ErrorDTO errorDTO = new ErrorDTO("Link invalidado","El link con id: "+e.getId()+", fue invalidado y ya no esta disponible");
        return new ResponseEntity<>(errorDTO, HttpStatus.I_AM_A_TEAPOT);
    }
}
