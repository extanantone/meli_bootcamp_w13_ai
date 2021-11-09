package com.example.blog.service;

import com.example.blog.dto.LinkDto;
import com.example.blog.exceptions.NullPointerException;
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
    public String redireccionar(int id){
        LinkDto encuentra = repositorioLink.buscarLink(id);
        if(encuentra == null){
            throw new NullPointerException("La url que busca no existe");
        }
        encuentra.setContador(encuentra.getContador()+1);
        return encuentra.getLink();
    }

    public int estadistica(int id){
        LinkDto encuentra = repositorioLink.buscarLink(id);
        if(encuentra == null){
            throw new NullPointerException("La url que busca no existe");
        }
        return encuentra.getContador();
    }
}
