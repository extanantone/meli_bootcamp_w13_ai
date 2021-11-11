package com.bootcamp.Mensajero.controller;

import com.bootcamp.Mensajero.dto.MensajeroDTO;
import com.bootcamp.Mensajero.service.IMensajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/Mensajero")
public class MensajeroController {

    @Autowired
    IMensajeroService iMensajeroService;


    @GetMapping("/mensaje")
    public ResponseEntity<MensajeroDTO> getMensaje(@RequestParam String msg, @RequestParam Long id){

        return new ResponseEntity<MensajeroDTO>( iMensajeroService.getmensajero(id,msg), HttpStatus.OK);

    }
}
