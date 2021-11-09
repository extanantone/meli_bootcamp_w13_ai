package com.bootcamp.linktracker.mapper;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkMetricsDTO;
import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Component;

@Component
public class LinkMapper {
    public Link LinkDTOtoLink(LinkDTO link) {
        return new Link(link.getLink(), link.getPassword(), 0, false);
    }

    public LinkDTO LinktoLinkDTO(Link link) {
        return new LinkDTO(link.getLink(), link.getPassword());
    }

    public LinkMetricsDTO LinkToLinkMetricsDTO(Link link) {
        return new LinkMetricsDTO(link.getLink(), link.getCount());
    }
}
