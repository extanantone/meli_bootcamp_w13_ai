package com.example.c4_man_excep_vivo_p1.controller;

import com.example.c4_man_excep_vivo_p1.dto.InputLinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.MetricsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/links")
public interface ILinkController
{
    @PostMapping("")
    public LinkDTO createLink(@RequestBody InputLinkDTO inputLinkDTO);

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> redirectLink(@PathVariable Integer linkId);

    @GetMapping("/metrics/{linkId}")
    public MetricsDTO metricsLink(@PathVariable Integer linkId);

    @PostMapping("invalidate/{linkId}")
    public LinkDTO invalidateLink(@PathVariable Integer linkId);
}
