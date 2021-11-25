package com.desafio_spring.principal.excepciones;

import com.desafio_spring.principal.dto.ErrorDTO;
import com.desafio_spring.principal.dto.ErrorDetalleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@ControllerAdvice(annotations = RestController.class)
public class HandlerExcepcionesGeneral {

    final Logger LOG = Logger.getLogger("excepciones.HandlerExcepcionesGeneral");

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErrorDTO> errorGeneralNegocio(NegocioException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getCodigo(),e.getMensaje(),null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> errorCritico(Exception e){
        e.printStackTrace();
        LOG.info("HA SUCEDIDO UN ERROR CRITICO EN LA API: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(500,e.getMessage(),null));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> errorValidacionesDtos(MethodArgumentNotValidException e) {

        List<ErrorDetalleDTO> listaDetalles = new ArrayList<>();
        e.getFieldErrors().forEach(x->listaDetalles.add(new ErrorDetalleDTO(x.getCodes().hashCode(), x.getDefaultMessage(), x.getField())));
        ErrorDTO salida = new ErrorDTO(400, "Error en campos ingresados",listaDetalles);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salida);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorDTO> errorValidacionesHttp(HttpMessageNotReadableException e) {

        if(e.getMessage().contains("DateTimeParseException"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(400, "formato de fecha incorrecto",null));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(400, e.getLocalizedMessage(),null));
    }

}
