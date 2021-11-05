package com.example.linktracker.controller;

import com.example.linktracker.dto.*;
import com.example.linktracker.exeption.MissingBodyException;
import com.example.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkControllerImpl implements ILinkController {

    @Autowired
    private ILinkService linkService;


    @Override
    public ResponseEntity<LinkRegisterResponseDTO> saveLink(@RequestBody LinkRegisterDTO link) {
        if(link == null) throw new MissingBodyException("El body de la request es necesario");
        Long newID = linkService.saveLink(link);
        return ResponseEntity.ok().body(new LinkRegisterResponseDTO(newID, "El link ha sido guardado correctamente"));
    }

    @Override
    public RedirectView redirect(Long id, String password) {
        String url = linkService.getURL(id, password);
        return new RedirectView(url);
    }

    @Override
    public ResponseEntity<InvalidateLinkResponseDTO> invalidateLink(Long id, InvalidateLinkDTO body) {
        if(body == null) throw new MissingBodyException("El body de la request es necesario");
        return ResponseEntity.ok().body(new InvalidateLinkResponseDTO(linkService.invalidateLink(id, body.getPassword()), "El Link ha sido invalidado"));
    }

    @Override
    public ResponseEntity<CountVisitsResponseDTO> getVisits(Long id) {
        return ResponseEntity.ok().body(new CountVisitsResponseDTO(linkService.getVisits(id), "OK"));
    }
}