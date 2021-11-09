package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkIdDTO;
import com.bootcamp.linktracker.dto.LinkMetricsDTO;
import com.bootcamp.linktracker.services.ILinkServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;

@RestController
public class LinkController {

    ILinkServices linkServices;

    public LinkController(ILinkServices linkServices) {
        this.linkServices = linkServices;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> postLink(@RequestBody LinkDTO link) {
        return new ResponseEntity<>(linkServices.createLink(link), HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirect(@PathVariable int linkId, @PathParam("password") String password ) {
        return new RedirectView(linkServices.redirect(linkId, password));
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsDTO> getMetrics(@PathVariable int linkId) {
        return new ResponseEntity<>(linkServices.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<String> invalidate(@PathVariable int linkId) {
        linkServices.invalidateLink(linkId);
        return new ResponseEntity<>("disabled",HttpStatus.OK);
    }
}
