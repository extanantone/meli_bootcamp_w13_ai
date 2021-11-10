package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.CreateLinkInDTO;
import com.bootcamp.linktracker.dto.CreateLinkOutDTO;
import com.bootcamp.linktracker.dto.CreateLinkPassInDTO;
import com.bootcamp.linktracker.dto.LinkStatisticsDTO;
import com.bootcamp.linktracker.exception.URLInvalidException;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import javax.management.Query;
import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    @Autowired
    ILinkService linkService;


    @GetMapping(path = "/metrics/{id}")
    public LinkStatisticsDTO getStatistics (@PathVariable(value = "id") Long linkId){

        return linkService.getLinkStatistics(linkId);
    }

    @PostMapping
    public CreateLinkOutDTO create(@RequestParam String url,
                                   @RequestParam(required = false) String pass) {

        if(pass == null){
            CreateLinkInDTO newUser = new CreateLinkInDTO(url);
            return linkService.createLink(newUser);

        }else{
            CreateLinkPassInDTO user = new CreateLinkPassInDTO(url,pass);
            return linkService.createLink(user);
        }

    }




}
