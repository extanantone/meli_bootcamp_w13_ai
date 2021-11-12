package com.desafio_spring.principal.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UsuariosController {

    @GetMapping("")
    public ResponseEntity<String> saludo(){
        return new ResponseEntity("hola mundo", HttpStatus.OK);
    }

}
