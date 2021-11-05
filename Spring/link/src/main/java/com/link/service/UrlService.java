package com.link.service;

import com.link.dtos.UrlDto;
import com.link.dtos.UrlResponseDto;
import com.link.exception.InvalidateUrlException;
import com.link.exception.UrlNotFoundException;
import com.link.model.Url;
import com.link.repository.IUrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService{

    private IUrlRepository iUrlRepository;

    public  UrlService(IUrlRepository iUrlRepository){
        this.iUrlRepository = iUrlRepository;
    }

    @Override
    public UrlResponseDto addUrl(UrlDto dto) {
        Url url = new Url(0,dto.getUrl(),true,0);
        url = iUrlRepository.addUrl(url);
        return new UrlResponseDto(url.getId(),url.getUrl());
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
        return null;
    }
}
