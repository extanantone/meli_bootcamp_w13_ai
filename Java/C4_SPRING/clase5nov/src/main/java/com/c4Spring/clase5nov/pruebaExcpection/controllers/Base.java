package com.c4Spring.clase5nov.controllers;

import com.c4Spring.clase5nov.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiBase")
public class Base {

    @Autowired
    private Servicio service;

    @GetMapping("")
    public String saludo(){
        return "Hola saludo";
    }

    @GetMapping("/excp")
    public String excepciones(@RequestParam("id") String id){
        return service.encontrar(id);
    }



}
