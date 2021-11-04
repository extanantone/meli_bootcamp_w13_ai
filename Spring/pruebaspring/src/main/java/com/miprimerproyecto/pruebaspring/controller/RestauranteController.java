package com.miprimerproyecto.pruebaspring.controller;

import com.miprimerproyecto.pruebaspring.dto.PlatoDTO;
import com.miprimerproyecto.pruebaspring.dto.PlatoDevueltoDTO;
import com.miprimerproyecto.pruebaspring.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/restaurante")
public class RestauranteController {

    @Autowired
    IPlatoService iPlatoService;

    @GetMapping("/plato")
    public   PlatoDevueltoDTO getPlato(@RequestBody PlatoDTO platoDTO){

        return iPlatoService.getPlato(platoDTO);
    }

}
