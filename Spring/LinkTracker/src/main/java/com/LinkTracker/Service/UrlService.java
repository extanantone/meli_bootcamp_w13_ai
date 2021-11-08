package com.LinkTracker.Service;

import com.LinkTracker.DTO.DtoUrlMetrics;
import com.LinkTracker.DTO.UrlDto;
import com.LinkTracker.DTO.UrlResponseDto;
import com.LinkTracker.Exception.InvalidateUrlException;
import com.LinkTracker.Exception.UrlNotFoundException;
import com.LinkTracker.Model.Url;
import com.LinkTracker.Repository.IUrlRepository;
import org.springframework.stereotype.Service;

@Service
public class UrlService implements IUrlService{

    private IUrlRepository iUrlRepository;

    public  UrlService(IUrlRepository iUrlRepository){
        this.iUrlRepository = iUrlRepository;
    }

    @Override
    public UrlResponseDto addUrl(UrlDto dto) {
        Url url = new Url(0,dto.getUrl(),true,dto.getPassword(),0);
        url = iUrlRepository.addUrl(url);
        return new UrlResponseDto(url.getId(),url.getUrl());
    }

    @Override
    public String getUrlById(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("URL No Encontrada");
        else if(!url.isActive())
            throw new InvalidateUrlException("URL No Valida");
        url.setRedirectNumber(url.getRedirectNumber()+1);
        iUrlRepository.update(url);
        return  url.getUrl();
    }

    @Override
    public void invalidateUrl(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("URL No Encontrada");
        else if(!url.isActive())
            throw new InvalidateUrlException("URL No Valida");
        url.setActive(false);
        iUrlRepository.update(url);
    }

    @Override
    public String getUrlByIdAndPassword(int id, String password) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("URL No Encontrada");
        else if(!url.isActive() || !url.getPassword().equals(password))
            throw new InvalidateUrlException("URL No Valida");
        url.setRedirectNumber(url.getRedirectNumber()+1);
        iUrlRepository.update(url);
        return url.getUrl();
    }

    @Override
    public DtoUrlMetrics getUrlMetricsById(int id) {
        Url url = iUrlRepository.findById(id);
        if(url==null)
            throw new UrlNotFoundException("URL No Encontrada");
        return new DtoUrlMetrics(url.getUrl(),url.getRedirectNumber());
    }

}
