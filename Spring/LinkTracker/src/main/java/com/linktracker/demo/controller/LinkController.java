package com.linktracker.demo.controller;

import com.linktracker.demo.DTO.LinkDTO;
import com.linktracker.demo.DTO.LinkInfoDTO;
import com.linktracker.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

//Libreria apache validator
//UrlValidator urlValidator = new UrlValidator(schemes);
//if (urlValidator.isValid("ftp://foo.bar.com/")) {

@RestController
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/link")
    public ResponseEntity<LinkInfoDTO> createLink(@RequestBody LinkDTO link) {

        return new ResponseEntity(iLinkService.crearLinkInfo(link), HttpStatus.OK);

    }

    @GetMapping("/redireccion/{idLink}/")
    public ResponseEntity<Object> redireccion(@PathVariable int idLink, @RequestParam("password") String password){

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(iLinkService.verificarExistenciaLink(idLink,password))).build();

    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<Integer> cantidadRedirecciones(@PathVariable int linkID){

        try {
            return new ResponseEntity(iLinkService.getCantRedirecciones(linkID), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidarLink(@PathVariable int linkId){

        try {
            return new ResponseEntity(iLinkService.invalidarLinkService(linkId), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }
}
