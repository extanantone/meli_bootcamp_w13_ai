package com.example.demo.controller;

import com.example.demo.dto.LinkDTO;
import com.example.demo.dto.LinkUrlDTO;
import com.example.demo.model.Link;
import com.example.demo.repository.ILinkRepository;
import com.example.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/save")
    public int guardarLink(@RequestBody LinkUrlDTO url){

        return iLinkService.guardarLink(url).getId();
    }

    @GetMapping("/links")
    public List<Link> obtenerLink(){
        return iLinkService.obtenerLinks();
    }

    @GetMapping("/redirect/{id}")
    public ResponseEntity<?> redirigirPorLinkId(@PathVariable int id){

        LinkDTO dto = new LinkDTO(id);
        HttpHeaders h = new HttpHeaders();
        h.add("Location",iLinkService.obtenerLinkPorID(dto).getUrl());
        return new ResponseEntity<>(h, HttpStatus.MOVED_PERMANENTLY);


    }

}
