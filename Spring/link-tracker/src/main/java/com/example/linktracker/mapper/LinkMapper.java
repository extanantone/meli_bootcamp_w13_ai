package com.example.linktracker.mapper;

import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.dto.LinkIdDTO;
import com.example.linktracker.dto.LinkUrlPassDTO;
import com.example.linktracker.entity.Link;

public class LinkMapper {

    public static Link urlDtoToLink(LinkUrlPassDTO dto) {
        Link link = new Link();
        link.setUrl(dto.getUrl());
        link.setPassword(dto.getPassword());
        link.setEsValido(true);
        link.setVecesRedireccionado(0);
        return link;
    }

    public static LinkIdDTO linkToIdDTO(Link link) {
        LinkIdDTO dto = new LinkIdDTO();
        dto.setLinkId(link.getLinkId());
        return dto;
    }

    public static LinkDTO linkToDTO(Link link) {
        LinkDTO dto = new LinkDTO();
        dto.setLinkId(link.getLinkId());
        dto.setUrl(link.getUrl());
        return dto;
    }
}
