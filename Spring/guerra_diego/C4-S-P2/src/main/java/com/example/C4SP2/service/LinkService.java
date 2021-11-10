package com.example.C4SP2.service;

import com.example.C4SP2.dto.LinkDto;
import com.example.C4SP2.dto.LinkMetricaDto;
import com.example.C4SP2.dto.LinkValidoDto;
import com.example.C4SP2.dto.LinkPasswordDto;
import com.example.C4SP2.exceptions.DuplicateException;
import com.example.C4SP2.exceptions.InvalidAuthenticationException;
import com.example.C4SP2.exceptions.InvalidLinkException;
import com.example.C4SP2.exceptions.NotFoundException;
import com.example.C4SP2.model.Link;
import com.example.C4SP2.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkDto crearLink(LinkPasswordDto linkDto) {
        Link link = new Link();
        link.setUrl(linkDto.getUrl());
        link.setPassword(linkDto.getPassword());

        if(linkRepository.buscarLink(link.getUrl()) != null){
            throw new DuplicateException("La URL ya esta registrada");
        }

        link.setMetrica(0);
        link.setValido(true);
        Link nuevoLink = linkRepository.crearLink(link);
        LinkDto linkDto1 = new LinkDto();
        linkDto1.setId(nuevoLink.getId());
        linkDto1.setUrl(nuevoLink.getUrl());

        return linkDto1;
    }

    @Override
    public LinkValidoDto redirectLink(LinkPasswordDto linkPasswordDto) {
        Link link = new Link();
        link.setId(linkPasswordDto.getId());
        link.setPassword(linkPasswordDto.getPassword());

        Link linkNuevo = linkRepository.linkValido(link);
        if (linkNuevo == null){
            throw new InvalidLinkException("Link actualmente invalido");
        }

        Link linkAutenticar = linkRepository.autenticar(link);
        if(linkAutenticar == null){
            throw new InvalidAuthenticationException("Credenciales invalidas");
        }

        linkRepository.aumentarMetrica(link);

        LinkValidoDto linkValidoDto = new LinkValidoDto();
        linkValidoDto.setId(linkNuevo.getId());
        linkValidoDto.setUrl(linkNuevo.getUrl());
        linkValidoDto.setValido(linkNuevo.isValido());
        return linkValidoDto;
    }

    @Override
    public LinkMetricaDto devolverMetrica(int id) {
        LinkMetricaDto linkMetricaDto = new LinkMetricaDto();

        Link linkMetrica = linkRepository.getMetricas(id);
        if (linkMetrica == null){
            throw new NotFoundException("Link no encontrado");
        }

        linkMetricaDto.setId(linkMetrica.getId());
        linkMetricaDto.setMetrica(linkMetrica.getMetrica());
        linkMetricaDto.setUrl(linkMetrica.getUrl());
        return linkMetricaDto;
    }

    @Override
    public LinkValidoDto invalidarLink(int id) {
        Link link = linkRepository.invalidarLink(id);
        if (link == null){
            throw new NotFoundException("Link no encontrado");
        }
        LinkValidoDto linkValidoDto = new LinkValidoDto();
        linkValidoDto.setId(link.getId());
        linkValidoDto.setUrl(link.getUrl());
        linkValidoDto.setValido(link.isValido());

        return linkValidoDto;
    }
}
