package com.bootcamp.Linktraker.demo.service;

import com.bootcamp.Linktraker.demo.dto.LinkDTO;
import com.bootcamp.Linktraker.demo.mapper.MapperLink;
import com.bootcamp.Linktraker.demo.model.Link;
import com.bootcamp.Linktraker.demo.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService  implements  ILinkService{

    @Autowired
    private ILinkRepository iLinkRepository;

    @Autowired
    private MapperLink mapperLink;

    @Override
    public LinkDTO postLink(LinkDTO linkDTO) {

        Link link = mapperLink.linkDTOToLink(linkDTO);

        long id = iLinkRepository.getMapLink().size()+1;

        link.setId(id);

        iLinkRepository.setLink(link);

        return mapperLink.LinkToLinkDTO(link);
    }

    @Override
    public String rederic(long id) {

        String url = iLinkRepository.getLink(id).getURL();

        return "redirect:/"+url;
    }
}
