package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.*;
import com.bootcamp.linktracker.exception.BadRequestException;
import com.bootcamp.linktracker.exception.NotFoundLinkException;
import com.bootcamp.linktracker.exception.URLInvalidException;
import com.bootcamp.linktracker.repository.ILinkReposiroty;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

@Service
public class LinkServiceImpl implements ILinkService {

    final ILinkReposiroty linkReposiroty;

    private final ModelMapper mapper;

    private  RestTemplate rs;

    public LinkServiceImpl(ILinkReposiroty linkReposiroty) {
        this.linkReposiroty = linkReposiroty;
        this.mapper = new ModelMapper();
        this.rs = new RestTemplate();
    }

    @Override
    public LinkStatisticsDTO getLinkStatistics(Long linkId) {
        var link = linkReposiroty.getLinkbyId(linkId);
        if(Objects.isNull(link)){
            throw new NotFoundLinkException("¡¡El link con el id: "+ linkId + " no existe!!");
        }else{
            return mapper.map(link,LinkStatisticsDTO.class);
        }
    }

    @Override
    public CreateLinkOutDTO createLink(CreateLinkInDTO linkDTO) {

        URL url;
        try {
            url = new URL(linkDTO.getUrl());
        } catch (MalformedURLException e) {
            throw new BadRequestException("URL invalida");
        }
        HttpURLConnection huc;
        int responseCode = 0;
        try {
            huc = (HttpURLConnection) url.openConnection();
            responseCode = huc.getResponseCode();

        } catch (IOException e) {
            throw new BadRequestException("URL invalida");
        }
        
        var link = linkReposiroty.createLink(linkDTO.getUrl());

        CreateLinkOutDTO out = new CreateLinkOutDTO(link.getLinkId(), link.getUrl());

        return out;

    }

    @Override
    public CreateLinkOutDTO createLink(CreateLinkPassInDTO linkDTO) {

        var link = linkReposiroty.createLink(linkDTO.getUrl(),linkDTO.getPass());

        CreateLinkOutDTO out = new CreateLinkOutDTO(link.getLinkId(),link.getUrl());

        return out;
    }


    @Override
    public CreateLinkOutDTO getUrl(Long linkId) {
        var link = linkReposiroty.getLinkbyId(linkId);
        if(Objects.isNull(link)){
            throw new NotFoundLinkException("¡¡El link con el id: "+ linkId + " no existe!!");
        }else{
            return mapper.map(link,CreateLinkOutDTO.class);
        }
    }



    @Override
    public CreateLinkOutDTO disableLink(Long linkId) {
        var link = linkReposiroty.getLinkbyId(linkId);
        if(Objects.isNull(link)){
            throw new NotFoundLinkException("¡¡El link con el id: "+ linkId + " no existe!!");
        }else{
            link.setActive(false);
            linkReposiroty.updateLink(link);
            return mapper.map(link,CreateLinkOutDTO.class);
        }
    }

    @Override
    public CreateLinkOutDTO enableLink(Long linkId) {
        return null;
    }

    @Override
    public CreateLinkOutDTO setPass(Long linkId, String pass) {
        return null;
    }

    @Override
    public LinkStatisticsDTO plusRedirects(Long linkId) {
        return null;
    }
}
