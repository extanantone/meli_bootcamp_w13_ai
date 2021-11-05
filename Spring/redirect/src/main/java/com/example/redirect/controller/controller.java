package com.example.redirect.controller;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.exceptions.NoPassParameter;
import com.example.redirect.service.ILinkService;
import com.example.redirect.service.LinkService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@RestController

public class controller {
    @Autowired
    ILinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<?> createLink(@RequestBody  LinkDTO link){
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/links/{linkid}")
    public ResponseEntity<?> redirection (@PathVariable Integer linkid, @RequestParam(defaultValue = "") String pass){
        if ( pass.equals("")) {
            throw new NoPassParameter("El parametro pass es necesario para hacer la solucitud");
        }
        return  ResponseEntity.status(HttpStatus.FOUND).location(URI.create(linkService.getRedirection(linkid, pass ))).build();
    }

    @GetMapping("/metrics/{linkid}")
    public ResponseEntity<?> getMetrics (@PathVariable Integer linkid){
        return new ResponseEntity<>(linkService.getMetrics(linkid), HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{linkid}")
    public ResponseEntity<?> invalidateLink (@PathVariable Integer linkid){
        return new ResponseEntity<>(linkService.invalideteLink(linkid), HttpStatus.OK);
    }
}
