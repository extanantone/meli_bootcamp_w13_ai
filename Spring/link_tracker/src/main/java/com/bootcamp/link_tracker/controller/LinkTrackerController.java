package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.LinkDTO;
import com.bootcamp.link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkDTO link, @RequestParam String passwd){
        this.linkTrackerService.crearLink();
    }

    @GetMapping("/link/{linkID}")
    public ResponseEntity<?> redireccionar(@PathVariable Integer linkID){

    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getEstadisticas(@PathVariable Integer linkID){

    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidarLink(@PathVariable Integer linkID){

    }


}
