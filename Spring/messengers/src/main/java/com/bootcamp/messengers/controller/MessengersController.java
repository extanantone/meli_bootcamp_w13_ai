package com.bootcamp.messengers.controller;

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

}
