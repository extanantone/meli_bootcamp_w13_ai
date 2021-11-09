package com.bootcamp.linktracker.services;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkIdDTO;
import com.bootcamp.linktracker.dto.LinkMetricsDTO;
import com.bootcamp.linktracker.exception.DisabledLinkException;
import com.bootcamp.linktracker.exception.InvalidLinkException;
import com.bootcamp.linktracker.exception.InvalidPasswordException;
import com.bootcamp.linktracker.mapper.LinkMapper;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

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
        if (!validarUrl(link.getLink())) {
            throw new InvalidLinkException();
        }
        return new LinkIdDTO(linkRepository.newLink(linkMapper.LinkDTOtoLink(link)));
    }

    @Override
    public String redirect(int linkId, String password) {
        Link link = linkRepository.getLink(linkId);
        System.out.println(link);
        if (link.isDisable()) {
            throw new DisabledLinkException();
        }
        if (!link.getPassword().equals("") && !link.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }
        link.setCount(link.getCount() + 1);
        return link.getLink();
    }

    @Override
    public LinkMetricsDTO getMetrics(int linkId) {
        return linkMapper.LinkToLinkMetricsDTO(linkRepository.getLink(linkId));
    }

    @Override
    public boolean invalidateLink(int linkId) {
        Link link = linkRepository.getLink(linkId);
        System.out.println(link);
        link.setDisable(true);
        System.out.println(link);
        return true;
    }

    private boolean validarUrl(String url) {
        try {
            URL validate = new URL(url);
            validate.toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidLinkException();
        }
        return true;
    }

}
