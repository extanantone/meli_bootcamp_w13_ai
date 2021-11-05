package com.example.linktracker.controller;

import com.example.linktracker.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkController {

    @PostMapping("/link")
    ResponseEntity<LinkRegisterResponseDTO> saveLink(@RequestBody LinkRegisterDTO link);

    @GetMapping("/link/{id}")
    RedirectView redirect(@PathVariable Long id, @RequestParam String password);

    @PostMapping("/invalidate/{id}")
    ResponseEntity<InvalidateLinkResponseDTO> invalidateLink(@PathVariable Long id, @RequestBody InvalidateLinkDTO body);

    @GetMapping("/metrics/{id}")
    ResponseEntity<CountVisitsResponseDTO> getVisits(@PathVariable Long id);
}
