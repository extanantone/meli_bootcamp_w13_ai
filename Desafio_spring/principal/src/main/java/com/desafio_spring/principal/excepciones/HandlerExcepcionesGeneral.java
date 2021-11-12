package com.desafio_spring.principal.excepciones;

import com.desafio_spring.principal.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@ControllerAdvice(annotations = RestController.class)
public class HandlerExcepcionesGeneral {

    final Logger LOG = Logger.getLogger("excepciones.HandlerExcepcionesGeneral");

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErrorDTO> errorGeneralNegocio(NegocioException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getCodigo(),e.getMensaje()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> errorCritico(Exception e){
        e.printStackTrace();
        LOG.info("HA SUCEDIDO UN ERROR CRITICO EN LA API: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(999,e.getMessage()));
    }

}
