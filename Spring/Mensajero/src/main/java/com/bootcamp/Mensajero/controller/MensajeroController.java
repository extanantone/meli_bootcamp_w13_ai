package com.bootcamp.Mensajero.controller;

import com.bootcamp.Mensajero.dto.MensajeDTO;
import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.service.IMensajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MensajeroController {
    IMensajeroService mensajeroService;

    public MensajeroController(IMensajeroService mensajeroService) {
        this.mensajeroService = mensajeroService;
    }

    @GetMapping("/mensajeros")
    public ResponseEntity<List<MensajeroDTO>> getMensajeros() {
        return new ResponseEntity<>(mensajeroService.getMensajeros(), HttpStatus.OK);
    }

    @GetMapping("/mensajero/{mensajeroId}")
    public ResponseEntity<MensajeDTO> getMensaje(
            @PathVariable long mensajeroId,
            @PathParam("mensaje") String mensaje) {
        return new ResponseEntity<>(mensajeroService.getMensaje(mensajeroId, mensaje), HttpStatus.OK);
    }

}
