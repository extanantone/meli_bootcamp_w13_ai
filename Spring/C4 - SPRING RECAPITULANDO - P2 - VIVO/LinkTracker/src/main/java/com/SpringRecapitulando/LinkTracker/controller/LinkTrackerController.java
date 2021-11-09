package com.SpringRecapitulando.LinkTracker.controller;

import com.SpringRecapitulando.LinkTracker.dto.LinkCreateDTO;
import com.SpringRecapitulando.LinkTracker.dto.LinkDTO;
import com.SpringRecapitulando.LinkTracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackerController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkCreateDTO linkCreateDTO){
        return new ResponseEntity<>(linkService.createLink(linkCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable int linkId){
        return new ResponseEntity<>(linkService.findLink(linkId), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> getLink(@PathVariable int linkId, @RequestParam String pass){
        return new ResponseEntity<>(linkService.addView(linkId, pass), HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/invalidate/{id}")
    public ResponseEntity<?> invalidate(@PathVariable int id){
        return new ResponseEntity<>("Link con id "+id+" invalidado", HttpStatus.OK);
    }
}
