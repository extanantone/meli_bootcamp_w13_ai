package com.example.blog.controller;

import com.example.blog.dto.LinkDto;
import com.example.blog.model.Link;
import com.example.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    LinkService servicioLink;

    @PostMapping("/link/")
    private ResponseEntity<String> crearEntrada(@RequestParam String  link, @RequestParam String  contrasena){
        LinkDto linkNuevo= servicioLink.crearLink(link, contrasena);
        return new ResponseEntity<>("Ha sido creado el link correctamente, el ID es:"+linkNuevo.getLinkId(), HttpStatus.OK);
    }
    @GetMapping("/link/{linkId}")
    private ResponseEntity<String> crearEntrada(@PathVariable int  linkId){
        ResponseEntity<String> linkNuevo= servicioLink.redireccionar(linkId);
        return linkNuevo;
    }

}
