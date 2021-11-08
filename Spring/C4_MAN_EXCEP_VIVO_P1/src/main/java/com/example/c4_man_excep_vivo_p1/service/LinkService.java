package com.example.c4_man_excep_vivo_p1.service;

import com.example.c4_man_excep_vivo_p1.dto.InputLinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.MetricsDTO;
import com.example.c4_man_excep_vivo_p1.exception.NotFoundException;
import com.example.c4_man_excep_vivo_p1.mapper.LinkMapper;
import com.example.c4_man_excep_vivo_p1.mapper.MetricsMapper;
import com.example.c4_man_excep_vivo_p1.model.Link;
import com.example.c4_man_excep_vivo_p1.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class LinkService implements ILinkService
{
    @Autowired
    ILinkRepository LinkRepository;

    @Autowired
    LinkMapper linkMapper;

    @Autowired
    MetricsMapper metricsMapper;

    @Override
    public LinkDTO invalidateLink(Integer linkId)
    {
        Map<Integer, Link> linkMap = LinkRepository.getMap();
        Link currentLink;
        if (linkMap.containsKey(linkId) && linkMap.get(linkId).isValid())
        {
            currentLink = linkMap.get(linkId);
            currentLink.setValid(false);
            LinkRepository.saveData(currentLink.getLinkId(), currentLink);
            return linkMapper.LinkToLinkDTO(currentLink);
        }
        throw new NotFoundException(linkId);
}

    @Override
    public ResponseEntity<Void> redirectLink(Integer linkId) throws NotFoundException
    {
        Map<Integer, Link> linkMap = LinkRepository.getMap();
        Link currentLink;
        if (linkMap.containsKey(linkId) && linkMap.get(linkId).isValid())
        {
            currentLink = linkMap.get(linkId);
            currentLink.increaseCounter();
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(currentLink.getUserLink())).build();
        }
        throw new NotFoundException(linkId);
    }

    @Override
    public MetricsDTO metricsLink(Integer linkId)
    {
        Map<Integer, Link> linkMap = LinkRepository.getMap();
        Link currentLink;
        if (linkMap.containsKey(linkId) && linkMap.get(linkId).isValid())
        {
            currentLink = linkMap.get(linkId);
            return metricsMapper.linkToMetricsDTO(currentLink);
        }
        throw new NotFoundException(linkId);
    }

    @Override
    public LinkDTO createLink(InputLinkDTO inputLinkDTO)
    {
        Link link = linkMapper.LinkDTOToLink(inputLinkDTO);
        LinkRepository.saveData(link.getLinkId(), link);
        return linkMapper.LinkToLinkDTO(link);
    }
}
