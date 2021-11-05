package com.bootcamp.linktracker.services;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkIdDTO;
import com.bootcamp.linktracker.dto.LinkMetricsDTO;
import com.bootcamp.linktracker.mapper.LinkMapper;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServices implements ILinkServices {
    ILinkRepository linkRepository;
    LinkMapper linkMapper;

    public LinkServices(ILinkRepository linkRepository, LinkMapper linkMapper) {
        this.linkRepository = linkRepository;
        this.linkMapper = linkMapper;
    }

    @Override
    public LinkIdDTO createLink(LinkDTO link) {
        return new LinkIdDTO(linkRepository.newLink(linkMapper.LinkDTOtoLink(link)));
    }

    @Override
    public String redirect(int linkId) {
        Link link = linkRepository.getLink(linkId);
        link.setCount(link.getCount()+1);
        return link.getLink();
    }

    @Override
    public LinkMetricsDTO getMetrics(int linkId) {
        return linkMapper.LinkToLinkMetricsDTO(linkRepository.getLink(linkId));
    }

    @Override
    public void invalidateLink(LinkIdDTO linkId) {

    }
}
