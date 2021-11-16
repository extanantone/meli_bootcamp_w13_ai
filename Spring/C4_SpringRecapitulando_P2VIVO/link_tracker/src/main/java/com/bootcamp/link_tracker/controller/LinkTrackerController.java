package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.EstadisticasDTO;
import com.bootcamp.link_tracker.dto.LinkDTO;
import com.bootcamp.link_tracker.dto.LinkResponseDTO;
import com.bootcamp.link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody String url, @RequestParam String password){
        Integer id = this.linkTrackerService.crearLink(url, password);
        LinkResponseDTO linkCreado = new LinkResponseDTO(id);
        return new ResponseEntity<>(linkCreado, HttpStatus.OK);
    }

    @GetMapping("/link/{linkID}")
    public ResponseEntity<?> redireccionar(@PathVariable Integer linkID){
        return null;
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getEstadisticas(@PathVariable Integer linkID){
        Integer cantRedirecciones = this.linkTrackerService.getEstadisticas(linkID);
        EstadisticasDTO estadisticas = new EstadisticasDTO(cantRedirecciones);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidarLink(@PathVariable Integer linkID){
        this.linkTrackerService.eliminarLink(linkID);
        return new ResponseEntity<>("Link eliminado correctamente", HttpStatus.OK);
    }


}
