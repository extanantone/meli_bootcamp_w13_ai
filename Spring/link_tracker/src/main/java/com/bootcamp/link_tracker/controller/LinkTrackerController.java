package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.EstadisticasDTO;
import com.bootcamp.link_tracker.dto.LinkInvalidadoResDTO;
import com.bootcamp.link_tracker.dto.LinkReqDTO;
import com.bootcamp.link_tracker.dto.LinkIdResDTO;
import com.bootcamp.link_tracker.service.ILinkTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {

    @Autowired
    private ILinkTrackerService linkTrackerService;

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkReqDTO link){
        Integer id = this.linkTrackerService.crearLink(link);
        LinkIdResDTO linkCreado = new LinkIdResDTO(id);
        return new ResponseEntity<>(linkCreado, HttpStatus.OK);
    }

    @GetMapping("/link/{linkID}")
    public ResponseEntity<?> redireccionar(@PathVariable Integer linkID, @RequestParam String password){
        String nuevaUrl = this.linkTrackerService.redireccionar(linkID, password);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", nuevaUrl);
        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT); //codigo 308
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getEstadisticas(@PathVariable Integer linkID){
        Integer cantRedirecciones = this.linkTrackerService.getEstadisticas(linkID);
        EstadisticasDTO estadisticas = new EstadisticasDTO(cantRedirecciones);
        return new ResponseEntity<>(estadisticas, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<?> invalidarLink(@PathVariable Integer linkID){
        this.linkTrackerService.invalidarLink(linkID);
       /* JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("message", "Link eliminado correctamente");
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return new ResponseEntity<>(new LinkInvalidadoResDTO("Link invalidado correctamente"), HttpStatus.OK);
    }

}
