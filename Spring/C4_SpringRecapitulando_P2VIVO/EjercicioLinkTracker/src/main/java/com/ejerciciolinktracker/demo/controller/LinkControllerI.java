package com.ejerciciolinktracker.demo.controller;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RequestMapping("/api/link")
public interface LinkControllerI {

    @PostMapping("/")
    public ResponseEntity<?> guardarLink(@RequestBody LinkDTO linkDTO);

    @GetMapping("/{linkId}")
    public ResponseEntity<?> redirectionLink(@PathVariable Integer linkId,@PathVariable String password) throws URISyntaxException;

    @GetMapping("/metrics/{linkId}/{password}")
    public ResponseEntity<?> metricasLink(@PathVariable Integer linkId,@PathVariable String password);

    @PostMapping("/invalidate/{linkId}/{password}")
    public ResponseEntity<?> ivalidarLink(@PathVariable Integer linkId,String password);

}
