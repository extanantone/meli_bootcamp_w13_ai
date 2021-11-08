package com.example.c4_man_excep_vivo_p1.mapper;

import com.example.c4_man_excep_vivo_p1.dto.InputLinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.model.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper
{
    public Link LinkDTOToLink(InputLinkDTO inputLinkDTO)
    {
        Link link = new Link();
        link.setUserLink(inputLinkDTO.getUserLink());
        link.setPassword(inputLinkDTO.getPassword());
        link.setValid(true);
        link.setLinkId(Link.linkIds);
        return link;
    }

    public LinkDTO LinkToLinkDTO(Link link)
    {
        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setLinkId(link.getLinkId());
        linkDTO.setUserLink(link.getUserLink());
        linkDTO.setValid(link.isValid());
        return linkDTO;
    }
}
