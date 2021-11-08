package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.dto.UrlDTO;
import com.bootcamp.linkTracker.dto.UrlResponseDTO;
import com.bootcamp.linkTracker.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class UrlController {

    @Autowired
    private IUrlService iUrlService;

    @PostMapping
    public UrlResponseDTO addUrl(@RequestBody UrlDTO dto){
        return iUrlService.addUrl(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable int id, @RequestParam(defaultValue = "") String password){
        HttpHeaders h = new HttpHeaders();
        h.add("Location",iUrlService.getUrlByIdAndPassword(id,password));
        return new ResponseEntity<>(h, HttpStatus.FOUND);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> ivalidate(@PathVariable int id){
        iUrlService.invalidateUrl(id);
        return ResponseEntity.ok().build();
    }

}
