package com.bootcamp.Mensajero.controller;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.dto.MensajeroTipoDTO;
import com.bootcamp.Mensajero.exception.NotFoundMensajeroException;
import com.bootcamp.Mensajero.service.IMensajeroService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MensajeroController {
    IMensajeroService mensajeroService;

    public MensajeroController(IMensajeroService mensajeroService) {
        this.mensajeroService = mensajeroService;
    }

    @GetMapping("/mensaje/{msj}/mensajero/{id}")
    public ResponseEntity<MensajeDTO> getMensaje(
            @PathVariable String msj, @PathVariable Long id)
            throws NotFoundMensajeroException {
        return new ResponseEntity<>(
                mensajeroService.retornarMensaje(id, msj),
                HttpStatus.OK
        );

    }

    @GetMapping("/mensajeroTipo/{id}")
    public ResponseEntity<MensajeroTipoDTO> getMensajeroTipo(
            @PathVariable Long id)
            throws NotFoundMensajeroException {
        return new ResponseEntity<>(
                mensajeroService.retornarMensajero(id),
                HttpStatus.OK
        );

    }

    @GetMapping("/mensajeros")
    public ResponseEntity<List<MensajeroDTO>> getMensajeros() {
        return new ResponseEntity<>(
                mensajeroService.listarMensajeros(),
                HttpStatus.OK
        );

    }

}
