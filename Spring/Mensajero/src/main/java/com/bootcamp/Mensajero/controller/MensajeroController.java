package com.bootcamp.Mensajero.controller;

import com.bootcamp.Mensajero.dto.MensajeroDto;
import com.bootcamp.Mensajero.dto.MensajerosDto;
import com.bootcamp.Mensajero.model.Mensajero;
import com.bootcamp.Mensajero.model.MensajeroAbstracto;
import com.bootcamp.Mensajero.service.IMensajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController

public class MensajeroController {
    IMensajeroService servicio;

    public MensajeroController(IMensajeroService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MensajerosDto>> listarMensajeros(){
        List<MensajerosDto> hola=servicio.listar();
        return new ResponseEntity<>(hola, HttpStatus.OK);
    }
    @PostMapping("/retornar")
    public ResponseEntity<MensajeroDto> retornarMensaje(@RequestParam String mensaje, @RequestParam Long mensajero) throws Exception {

        return new ResponseEntity<>(servicio.retornarMensaje(mensaje, mensajero), HttpStatus.OK);
    }
    @GetMapping("/mensaje/{msj}/mensajero/{id}")
    public ResponseEntity<MensajeroDto> retornarMensaje2(@PathVariable("msj") String msj, @PathVariable("id") Long id) throws Exception {
        return new ResponseEntity<>(servicio.retornarMensaje(msj, id), HttpStatus.OK);
    }
}
