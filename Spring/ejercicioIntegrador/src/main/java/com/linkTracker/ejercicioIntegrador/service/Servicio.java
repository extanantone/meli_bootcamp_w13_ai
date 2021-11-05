package com.linkTracker.ejercicioIntegrador.service;

import com.linkTracker.ejercicioIntegrador.dto.LinkDto;
import com.linkTracker.ejercicioIntegrador.model.Link;
import com.linkTracker.ejercicioIntegrador.repository.IlinkRepository;
import com.linkTracker.ejercicioIntegrador.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio implements LinkServicio{
    private IlinkRepository linkRepository;

    public Servicio(IlinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Override
    public LinkDto crearLink(LinkDto linkDto) {
        Link link = new Link();
        link.setContrasena(linkDto.getContrasena());
        link.setUrl(linkDto.getUrl());
        link.setId();
        link.setContador(0);
        return null;
    }
}
