package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkCreationReqDTO;
import com.bootcamp.linktracker.dto.LinkCreationResDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;


@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkCreationResDTO createLink(LinkCreationReqDTO linkCreationReqDTO) {
        Link newLink = new Link(linkCreationReqDTO.getUrl());
        return new LinkCreationResDTO(linkRepository.createLink(newLink));
    }

    @Override
    public LinkDTO getLink(int id) {
        return new LinkDTO(linkRepository.getLink(id));
    }

    @Override
    public void countVisit(int id) {
        linkRepository.countVisit(id);
    }
}
