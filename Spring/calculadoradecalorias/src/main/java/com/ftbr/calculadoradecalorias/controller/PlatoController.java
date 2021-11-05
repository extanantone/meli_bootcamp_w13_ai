package com.ftbr.calculadoradecalorias.controller;

import com.ftbr.calculadoradecalorias.dto.PlatoDTO;
import com.ftbr.calculadoradecalorias.dto.PlatoRequestDTO;
import com.ftbr.calculadoradecalorias.service.IPlatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {
    IPlatoService platoService;

    public PlatoController(IPlatoService platoService) {
        this.platoService = platoService;
    }

    @PostMapping("/plato")
    public ResponseEntity<PlatoDTO> getCallorias(@RequestBody PlatoRequestDTO plato) {
        return new ResponseEntity<>( platoService.calcuarCalorias(plato) , HttpStatus.OK);
    }
    @PostMapping("/platos")
    public ResponseEntity<List<PlatoDTO>> getCalloriasPlatos(@RequestBody List<PlatoRequestDTO>  platos) {
        return new ResponseEntity<>( platoService.calcuarCaloriasLista(platos) , HttpStatus.OK);
    }
}
