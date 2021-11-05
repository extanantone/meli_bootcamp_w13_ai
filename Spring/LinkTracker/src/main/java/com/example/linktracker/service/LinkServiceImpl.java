package com.example.linktracker.service;

import com.example.linktracker.dto.LinkRegisterDTO;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exeption.InvalidURLException;
import com.example.linktracker.exeption.WrongPasswordException;
import com.example.linktracker.mapper.LinkMapper;
import com.example.linktracker.repository.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public Long saveLink(LinkRegisterDTO registerDTO) {
        return linkRepository.saveLink(linkMapper.dtoToLink(registerDTO));
    }

    @Override
    public String getURL(Long id, String password) {
        Link link = linkRepository.getLink(id);
        if (link == null) throw new InvalidURLException();
        if (!link.getPassword().equals(password)) throw new WrongPasswordException("Contraseña invalida");
        if (Boolean.FALSE.equals(link.getActive())) throw new InvalidURLException();
        if (!new UrlValidator().isValid(link.getUrl())) throw new InvalidURLException();
        linkRepository.incrementeVisits(id);
        return link.getUrl();
    }

    @Override
    public Boolean invalidateLink(Long id, String password) {
        Link link = linkRepository.getLink(id);
        if (!link.getPassword().equals(password)) throw new WrongPasswordException("Contraseña invalida");
        linkRepository.invalidateLink(id);
        return true;
    }

    @Override
    public Long getVisits(Long id) {
        Link link = linkRepository.getLink(id);
        return link.getVisits();
    }
}
