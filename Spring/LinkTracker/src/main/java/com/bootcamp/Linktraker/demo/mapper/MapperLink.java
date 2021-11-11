package com.bootcamp.Linktraker.demo.mapper;

import com.bootcamp.Linktraker.demo.dto.LinkDTO;
import com.bootcamp.Linktraker.demo.model.Link;
import org.springframework.stereotype.Component;

@Component
public class MapperLink {

    public Link linkDTOToLink (LinkDTO linkDTO){
        return  new Link(linkDTO.getURL(),linkDTO.getPass(),linkDTO.getId());
    }

    public LinkDTO LinkToLinkDTO (Link link){
        return new LinkDTO(link.getURL(),link.getPass(),link.getId());
    }
}
