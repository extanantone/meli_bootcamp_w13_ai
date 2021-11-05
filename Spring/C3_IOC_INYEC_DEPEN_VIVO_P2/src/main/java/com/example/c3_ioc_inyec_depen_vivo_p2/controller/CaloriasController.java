package com.example.c3_ioc_inyec_depen_vivo_p2.controller;

import com.example.c3_ioc_inyec_depen_vivo_p2.dto.CaloriasDTO;
import com.example.c3_ioc_inyec_depen_vivo_p2.model.Plato;
import com.example.c3_ioc_inyec_depen_vivo_p2.service.ICaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CaloriasController
{
    @Autowired
   ICaloriasService caloriasService;

    @PostMapping("calorias")
    public ResponseEntity<List<CaloriasDTO>> consultCallorias(@RequestBody List<Plato> platos)
    {
        return new ResponseEntity<>(caloriasService.calcularParametros(platos), HttpStatus.OK);
    }
}
