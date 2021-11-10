package com.bootcamp.EJREPMessengers.controller;

import com.bootcamp.EJREPMessengers.dto.AMensajeroDTO;
import com.bootcamp.EJREPMessengers.service.IMensajeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajero")
public class MensajeroController {
    IMensajeroService iMensajeroService;

    public MensajeroController(IMensajeroService iMensajeroService) {
        this.iMensajeroService = iMensajeroService;
    }

    @GetMapping("/listar")
    public List<AMensajeroDTO> devolverMensajeros() {
        return iMensajeroService.devolverMensajeros();
    }

    @PostMapping("/mensaje")
    public String devolverMensaje(@RequestBody AMensajeroDTO aMensajeroDTO) {
        return iMensajeroService.devolverMensaje(aMensajeroDTO);
    }
}
