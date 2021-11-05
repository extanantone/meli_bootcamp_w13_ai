package com.example.redirect.service;

import com.example.redirect.dto.LinkDTO;
import com.example.redirect.map.LinkMapper;
import com.example.redirect.model.Link;
import com.example.redirect.repository.RepositoryLink;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    RepositoryLink repositorio;

    @Override
    public Integer createLink(LinkDTO link) {
        return repositorio.create(LinkMapper.LinkDTOtoLink(link));

    }
}
