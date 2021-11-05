package com.example.linktracker.demo.controller;

import com.example.linktracker.demo.DTO.LinkDTO;
import com.example.linktracker.demo.DTO.RespuestaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.Param;

@RestController
public class Controlador {
    @PostMapping("/link")
    public ResponseEntity<RespuestaDTO>(@RequestBody LinkDTO link){



    }
}
