package com.SpringRecapitulando.LinkTracker.service;

import com.SpringRecapitulando.LinkTracker.dto.LinkCreateDTO;
import com.SpringRecapitulando.LinkTracker.dto.LinkDTO;
import com.SpringRecapitulando.LinkTracker.entity.Link;
import com.SpringRecapitulando.LinkTracker.exception.BadRequestException;
import com.SpringRecapitulando.LinkTracker.exception.NotFoundException;
import com.SpringRecapitulando.LinkTracker.mapper.LinkMapper;
import com.SpringRecapitulando.LinkTracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    @Autowired
    LinkRepository linkRepository;

    @Override
    public LinkDTO findLink(int linkId) {
        Link searchLink = linkRepository.findById(linkId);
        if (searchLink == null) {
            throw new NotFoundException("Link con id "+linkId+" no encontrado");
        } else {
            return LinkMapper.linkToLinkDTO(searchLink);
        }
    }

    @Override
    public LinkDTO createLink(LinkCreateDTO link) {
        Link newLink = new Link();
        newLink.setUrl(link.getUrl());
        newLink.setPassword(link.getPass());
        Link newLinkCreated = linkRepository.createLink(newLink);
        if (newLinkCreated == null){
            throw new BadRequestException("Url ya agregada");
        }
        return LinkMapper.linkToLinkDTO(newLinkCreated);
    }

    @Override
    public boolean invalidateLink(int id) {
        Link searchLink = linkRepository.invalidateLink(id);
        if (searchLink == null) {
            throw new NotFoundException("Link con id "+id+" no encontrado");
        } else {
            return true;
        }
    }

    @Override
    public LinkDTO addView(int linkId, String pass) {
        Link searchLink = linkRepository.findById(linkId);
        if (searchLink == null) {
            throw new NotFoundException("Link con id "+linkId+" no encontrado");
        } else {
            if (!searchLink.getPassword().equals(pass)){
                throw new BadRequestException("Contraseña incorrecta");
            }
            Link link = linkRepository.addView(linkId);

            return LinkMapper.linkToLinkDTO(link);
        }
    }
}
