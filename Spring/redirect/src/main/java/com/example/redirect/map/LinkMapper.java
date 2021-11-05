package com.example.redirect.map;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.model.Link;

public class LinkMapper {
    public static Link LinkDTOtoLink(LinkDTO link){
        Link newLink = new Link();
        newLink.setUrl(link.getUrl());
        newLink.setPass(link.getPass());
        newLink.setMetrics(link.getMetrics());

        return newLink;
    }
}
