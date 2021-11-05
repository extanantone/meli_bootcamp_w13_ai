package com.linktracker.demo.service;

import com.linktracker.demo.DTO.LinkDTO;
import com.linktracker.demo.DTO.LinkInfoDTO;
import com.linktracker.demo.model.Link;
import com.linktracker.demo.repository.ILinkRepository;
import com.linktracker.demo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository iLinkRepository;

    @Override
    public LinkInfoDTO crearLinkInfo(LinkDTO linkDTO) {

        Link link = new Link(linkDTO.getLink(),true);

        LinkInfoDTO res = new LinkInfoDTO();
        res.setLink(linkDTO.getLink());
        res.setId(iLinkRepository.agregarListaLinks(link));
        
        return res;

    }

}
