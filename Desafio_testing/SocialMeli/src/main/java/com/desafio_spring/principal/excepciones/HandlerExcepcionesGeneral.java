package com.desafio_spring.principal.excepciones;

import com.desafio_spring.principal.dto.ErrorDTO;
import com.desafio_spring.principal.dto.ErrorDetalleDTO;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;


@ControllerAdvice(annotations = RestController.class)
public class HandlerExcepcionesGeneral {

    private static final Logger LOG = Logger.getLogger("excepciones.HandlerExcepcionesGeneral");

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

        final AtomicInteger count = new AtomicInteger();
        List<ErrorDetalleDTO> listaDetalles = new ArrayList<>();
        e.getFieldErrors().forEach(x->listaDetalles.add(new ErrorDetalleDTO(count.addAndGet(1), x.getDefaultMessage(), x.getField())));
        ErrorDTO salida = new ErrorDTO(400, "Error en campos ingresados",listaDetalles);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(salida);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorDTO> errorValidacionesHttp(HttpMessageNotReadableException e) {

        String mensaje = e.getMessage();
        if(mensaje!=null && mensaje.contains("DateTimeParseException"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(400, "formato de fecha incorrecto",null));

        if(mensaje!=null && mensaje.contains("InvalidFormatException"))
        {
            String[] path = ((InvalidFormatException) e.getCause()).getPathReference().split("\\.");
            String[] claseCampo = path[path.length-1].split("[\\[\\]]");
            String campo = claseCampo[claseCampo.length-1];
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(400, "Error en el formato del dato ingresado: " + campo , null));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(400, e.getLocalizedMessage(),null));
    }

}
