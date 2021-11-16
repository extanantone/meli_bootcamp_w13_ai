package com.ejerciciolinktracker.demo.mapper;

import com.ejerciciolinktracker.demo.dto.LinkDTO;
import com.ejerciciolinktracker.demo.model.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {

    public Link linkDTOToLink(LinkDTO linkDTO,Integer id){
        return new Link(linkDTO.getLinkUrl(),id,0,1);
    }

    public LinkDTO linkToLinkDTO(Link link){
        return new LinkDTO(link.getUrl());
    }
}
