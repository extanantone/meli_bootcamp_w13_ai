package com.example.redirect.controller;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.service.ILinkService;
import com.example.redirect.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class controller {
    @Autowired
    ILinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<?> createLink(@RequestBody  LinkDTO link){
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.OK);
    }
}
