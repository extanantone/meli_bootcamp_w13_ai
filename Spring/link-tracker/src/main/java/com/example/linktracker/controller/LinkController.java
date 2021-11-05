package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkUrlPassDTO;
import com.example.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkIdDTO> crear(@RequestBody LinkUrlPassDTO dto) {
        LinkIdDTO linkIdDTO = linkService.guardar(dto);
        return new ResponseEntity<>(linkIdDTO, HttpStatus.CREATED);
    }

    @GetMapping("/redirect/link/{id}")
    public RedirectView redireccionar(@PathVariable Integer id,
                                 @RequestParam String pass) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://" + linkService.redireccionar(id, pass));
        return redirectView;
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<LinkDTO> invalidar(@PathVariable Integer id) {
        LinkDTO dto = linkService.invalidar(id);
        if (dto == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
