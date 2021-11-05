package com.example.blog.service;

import com.example.blog.dto.LinkDto;
import com.example.blog.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository repositorioLink;

    @Override
    public LinkDto crearLink(String link, String contrasena) {
        LinkDto nuevoLink = new LinkDto(0, link,contrasena,0);
        repositorioLink.añadirLinks(nuevoLink);
        return nuevoLink;
    }
    public ResponseEntity<String> redireccionar(int id){
        String mensaje="";
        LinkDto encuentra = repositorioLink.buscarLink(id);
        if(encuentra == null){
            mensaje= "invalido";
            return new ResponseEntity<String>(mensaje, HttpStatus.BAD_REQUEST);
        }
        mensaje="redirect:"+encuentra.getLink();
        return new ResponseEntity<String>(mensaje, HttpStatus.PERMANENT_REDIRECT);
    }
}
