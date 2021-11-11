package com.bootcamp.Linktraker.demo.controller;

import com.bootcamp.Linktraker.demo.dto.LinkDTO;
import com.bootcamp.Linktraker.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/Links")
public class LinkController {

    @Autowired
    ILinkService iLinkService;

    @PostMapping("/link")
    public ResponseEntity<?> posLink(@RequestParam String url , @RequestParam String pass){

        return new ResponseEntity<LinkDTO>(iLinkService.postLink(new LinkDTO(url,pass)), HttpStatus.OK);
    }


    @GetMapping("/{linkId}")
    public String rederic (@PathVariable long id){

        return iLinkService.rederic(id);
    }

}
