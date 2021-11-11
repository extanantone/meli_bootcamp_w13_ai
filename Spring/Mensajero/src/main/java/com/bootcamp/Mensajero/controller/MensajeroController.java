package com.bootcamp.Mensajero.controller;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.service.IMensajeroService;
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

    @GetMapping("mensaje/{mensaje}/mensajero/{mensajeroId}")
    public ResponseEntity<MensajeDTO> getMensaje(
            @PathVariable String mensaje,
            @PathVariable Long mensajeroId) {
        return new ResponseEntity<>(
                mensajeroService.retornarMensaje(mensajeroId, mensaje),
                HttpStatus.OK);
    }

    @GetMapping("mensajeros")
    public ResponseEntity<List<MensajeroDTO>> getMensajeros() {
        return new ResponseEntity<>(
                mensajeroService.listarMensajeros(),
                HttpStatus.OK);
    }
}
