package com.example.link_tracker.Controller;

import com.example.link_tracker.Dto.LinkDto;
import com.example.link_tracker.Dto.ResponeLinkDto;
import com.example.link_tracker.Service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class linkController {
    @Autowired
     LinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<ResponeLinkDto> crearLink(@RequestBody LinkDto link){
        ResponeLinkDto response = linkService.crearLink(link);
        return new ResponseEntity<ResponeLinkDto>(response, HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redireccion(@PathVariable int linkId){
        String url = linkService.obtenerDatosEnlace(linkId).getUrl();
        return new ModelAndView("redirect:"+ url);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<ResponeLinkDto> obtener(@PathVariable int linkId){
        ResponeLinkDto link = linkService.obtenerDatosEnlace(linkId);
        return new ResponseEntity<ResponeLinkDto>(link,HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<ResponeLinkDto> invalidarLink (@PathVariable int linkId){
        ResponeLinkDto response = linkService.invalidar(linkId);
        return new ResponseEntity<ResponeLinkDto>(response,HttpStatus.OK);
    }
}
