package com.bootcamp.messengers.controller;

import com.bootcamp.messengers.dto.CelularStateDTO;
import com.bootcamp.messengers.dto.InfoDTO;
import com.bootcamp.messengers.dto.PalomaStateDTO;
import com.bootcamp.messengers.dto.TelegrafoStateDTO;
import com.bootcamp.messengers.service.IMessengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessengersController {

    @Autowired
    private IMessengersService messengersService;

    @GetMapping("/mensajeros")
    public ResponseEntity<?> getMensajeros(){
        return new ResponseEntity<>(this.messengersService.getMensajeros(), HttpStatus.OK);
    }

    @GetMapping("/mensajeros/{id}")
    public ResponseEntity<?> retornarMensaje(@PathVariable Integer id, @RequestParam String mensaje){
        return new ResponseEntity<>(this.messengersService.getMensaje(id, mensaje), HttpStatus.OK);
    }

    @PutMapping("/mensajeros/paloma/estado")
    public ResponseEntity<?> modificarEstado(@RequestBody PalomaStateDTO estadoPaloma){
        this.messengersService.setEstadoPaloma(estadoPaloma);
        return new ResponseEntity<>(new InfoDTO("Paloma alimentada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/mensajeros/celular/estado")
    public ResponseEntity<?> modificarEstado(@RequestBody CelularStateDTO estadoCelular){
        this.messengersService.setEstadoCelular(estadoCelular);
        return new ResponseEntity<>(new InfoDTO("Se ha cargado saldo y bateria al celular correctamente"), HttpStatus.OK);
    }

    @PutMapping("/mensajeros/telegrafo/estado")
    public ResponseEntity<?> modificarEstado(@RequestBody TelegrafoStateDTO estadoTelegrafo){
        this.messengersService.setEstadoTelegrafo(estadoTelegrafo);
        return new ResponseEntity<>(new InfoDTO("Telegrafo conectado correctamente"), HttpStatus.OK);
    }
}
