package com.linktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.linktracker.dto.LinkDTO;
import com.linktracker.dto.LinkInfoDTO;
import com.linktracker.service.ILinkService;

import java.net.URI;

@RestController
public class LinkController {
    @Autowired
    ILinkService service;

    @PostMapping("/link")
    public ResponseEntity<LinkInfoDTO> createLink(@RequestBody LinkDTO link) {
        return new ResponseEntity(service.createLinkInfo(link), HttpStatus.OK);
    }


    @GetMapping("/redirect/{idLink}/")
    public ResponseEntity<Object> redirect(@PathVariable int linkId, @RequestParam("password") String password) {

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(service.verifyLinkExistence(linkId, password))).build();

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> amountRedirects(@PathVariable int linkId) {

        try {
            return new ResponseEntity(service.getAmountRedirects(linkId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @PutMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable int linkId) {

        try {
            return new ResponseEntity(service.invalidateLink(linkId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
