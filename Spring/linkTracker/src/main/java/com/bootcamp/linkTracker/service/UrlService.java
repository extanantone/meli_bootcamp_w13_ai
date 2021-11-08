package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.dto.UrlDTO;
import com.bootcamp.linkTracker.dto.UrlMetricsDTO;
import com.bootcamp.linkTracker.dto.UrlResponseDTO;
import com.bootcamp.linkTracker.exception.InvalidateUrlException;
import com.bootcamp.linkTracker.exception.UrlNotFoundException;
import com.bootcamp.linkTracker.model.Url;
import com.bootcamp.linkTracker.repository.IUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService{

    @Autowired
    private IUrlRepository iUrlRepository;

    @Override
    public UrlResponseDTO addUrl(UrlDTO dto) {
        Url url = new Url(0,dto.getUrl(),true,dto.getPassword(),0);
        url = iUrlRepository.addUrl(url);
        return new UrlResponseDTO(url.getId(),url.getUrl());
    }

    @Override
    public String getUrlById(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("Not found");
        else if(!url.isActive())
            throw new InvalidateUrlException("Not valid");
        url.setRedirectNumber(url.getRedirectNumber()+1);
        iUrlRepository.update(url);
        return  url.getUrl();
    }

    @Override
    public void invalidateUrl(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("Not found");
        else if(!url.isActive())
            throw new InvalidateUrlException("Not valid");
        url.setActive(false);
        iUrlRepository.update(url);
    }

    @Override
    public String getUrlByIdAndPassword(int id, String password) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("Not found");
        else if(!url.isActive() || !url.getPassword().equals(password))
            throw new InvalidateUrlException("Not valid");
        url.setRedirectNumber(url.getRedirectNumber()+1);
        iUrlRepository.update(url);
        return url.getUrl();
    }

    @Override
    public UrlMetricsDTO getUrlMetricsById(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("Not found");
        return new UrlMetricsDTO(url.getUrl(),url.getRedirectNumber());
    }
}
