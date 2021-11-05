package com.c4.p2.controller;

import com.c4.p2.dto.LinkCreatorDto;
import com.c4.p2.dto.LinkIdDto;
import com.c4.p2.dto.RedireccionesDto;
import com.c4.p2.exceptions.NotFoundException;
import com.c4.p2.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api")
public class LinkTrackerController {

    ILinkService linkService;

    public LinkTrackerController(ILinkService linkService){
        this.linkService = linkService;
    }

    @PostMapping("/")
    public ResponseEntity<LinkIdDto> crearLink(@RequestBody LinkCreatorDto linkCreator){
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.nuevoLink(linkCreator));
    }

    @GetMapping("/link/{linkId}")
    public ModelAndView redireccionar(@PathVariable Integer linkId, @RequestParam String pass){
        String url = linkService.permiteRedireccion(linkId, pass);
        if (url != null)
            return new ModelAndView("redirect:" + url);
        return new ModelAndView();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<RedireccionesDto> obtenerRedirecciones(@PathVariable Integer linkId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.obtenerEstadisticas(linkId));
    }

    @GetMapping("/invalidate/{linkId}")
    public HttpStatus invalidarLink(@PathVariable Integer linkId) throws NotFoundException {
        linkService.invalidarLink(linkId);
        return HttpStatus.OK;
    }
}
