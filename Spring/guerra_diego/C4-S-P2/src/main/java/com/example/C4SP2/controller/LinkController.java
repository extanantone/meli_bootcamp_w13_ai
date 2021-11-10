package com.example.C4SP2.controller;

import com.example.C4SP2.dto.LinkDto;
import com.example.C4SP2.dto.LinkMetricaDto;
import com.example.C4SP2.dto.LinkPasswordDto;
import com.example.C4SP2.dto.LinkValidoDto;
import com.example.C4SP2.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<LinkDto> postLink(@RequestBody LinkPasswordDto linkDto){
        LinkDto nuevoLink = linkService.crearLink(linkDto);
        return new ResponseEntity<>(nuevoLink, HttpStatus.OK);
    }

    @GetMapping("link/{linkId}")
    public RedirectView redirectLink(
            @PathVariable int linkId,
            @RequestParam String password
    ){
        LinkPasswordDto linkPasswordDto = new LinkPasswordDto(linkId,"",password);
        LinkValidoDto linkValidoDto = linkService.redirectLink(linkPasswordDto);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkValidoDto.getUrl());
        return redirectView;
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<LinkMetricaDto> getMetricas(@PathVariable int linkId){
        LinkMetricaDto linkMetricaDto = linkService.devolverMetrica(linkId);
        return new ResponseEntity<>(linkMetricaDto,HttpStatus.OK);
    }

    @PostMapping("invalidate/{linkId}")
    public String invalidarLink(@PathVariable int linkId){
        LinkValidoDto linkValidoDto = linkService.invalidarLink(linkId);
        return "El link con id " + linkValidoDto.getId() + "se ha invalidado";
    }

}
