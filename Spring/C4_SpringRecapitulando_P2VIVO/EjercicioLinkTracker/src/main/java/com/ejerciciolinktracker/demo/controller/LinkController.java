package com.ejerciciolinktracker.demo.controller;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import com.ejerciciolinktracker.demo.service.LinkServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class LinkController implements LinkControllerI{
    @Autowired
    LinkServiceI linkService;

    public ResponseEntity<?> guardarLink(@RequestBody LinkDTO linkDTO){
        return new ResponseEntity(linkService.guardarLink(linkDTO), HttpStatus.OK);
    }

    public ResponseEntity<?> redirectionLink(@PathVariable Integer linkId,@PathVariable String password) throws URISyntaxException {
        String url = linkService.mostrarLink(linkId,password);

        URI yahoo = new URI("http://"+url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(yahoo);

        return new ResponseEntity<>(httpHeaders, HttpStatus.PERMANENT_REDIRECT);
    }

    @Override
    public ResponseEntity<?> metricasLink(Integer linkId,String password) {
        return new ResponseEntity(linkService.cantUsosLink(linkId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> ivalidarLink(Integer linkId,String password) {
        return new ResponseEntity(linkService.cantUsosLink(linkId),HttpStatus.OK);
    }
}
