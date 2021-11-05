package com.example.demo.controller;

import com.example.demo.dto.LinkMetricsDTO;
import com.example.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    ILinkService iLinkService;

@GetMapping("/link/{id}")
    public ResponseEntity<LinkMetricsDTO> obtenerMetricasPorLinkId(@PathVariable int id){

    return new ResponseEntity<>(iLinkService.obtenerMetricasPorLinkId(id), HttpStatus.OK);
}


}
