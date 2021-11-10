package com.Bootcamp.C4P2EJ1.mapper;

import com.Bootcamp.C4P2EJ1.dto.LinkDTO;
import com.Bootcamp.C4P2EJ1.model.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {
    public Link linkDTOALink(LinkDTO linkDTO) {
        Link link = new Link();
        link.setId(linkDTO.getId());
        link.setUrl(linkDTO.getUrl());
        link.setPassword(linkDTO.getPassword());
        link.setContador(linkDTO.getContador());
        return link;
    }

    public LinkDTO linkALinkDTO(Link link) {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setId(link.getId());
        linkDTO.setUrl(link.getUrl());
        linkDTO.setPassword(link.getPassword());
        linkDTO.setContador(link.getContador());
        return linkDTO;
    }
}
