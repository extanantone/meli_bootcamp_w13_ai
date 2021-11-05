package com.linktracker.demo.controller;

import com.linktracker.demo.DTO.LinkDTO;
import com.linktracker.demo.DTO.LinkInfoDTO;
import com.linktracker.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/redireccion/{idLink}")
    public String redireccion(@PathVariable int idLink){

        return "redirect:";// + link;
    }
}
