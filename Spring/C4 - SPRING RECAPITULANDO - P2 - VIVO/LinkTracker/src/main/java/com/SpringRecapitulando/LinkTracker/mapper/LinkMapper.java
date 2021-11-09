package com.SpringRecapitulando.LinkTracker.mapper;

import com.SpringRecapitulando.LinkTracker.dto.LinkDTO;
import com.SpringRecapitulando.LinkTracker.entity.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {

    public static Link linkDTOToLink(LinkDTO linkDTO) {
        Link link = new Link();
        link.setId(linkDTO.getId());
        link.setViews(linkDTO.getViews());
        return link;
    }

    public static LinkDTO linkToLinkDTO(Link link){
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setId(link.getId());
        linkDTO.setUrl(link.getUrl());
        linkDTO.setViews(link.getViews());
        linkDTO.setValidate(link.isValidate());
        return linkDTO;
    }
}
